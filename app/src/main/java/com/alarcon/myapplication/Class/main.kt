package com.alarcon.myapplication.Class

fun main() {
    val library = Library()
    val loanManager = LibraryLoan()

    println("Welcome to the library management system!")

     while (true) {
        displayMainMenu()

        when (readMainMenuOption()) {
            MainMenuOption.ADD_BOOK -> {
                library.addBook()
            }
            MainMenuOption.REMOVE_BOOK -> {
                library.removeBook()
            }
            MainMenuOption.DISPLAY_ALL_BOOKS -> {
                library.displayAllBooks()
            }
            MainMenuOption.CREATE_LOAN -> {
                if (library.getAllBooks(BookStatus.AVAILABLE).isEmpty()) {
                    println("There are no available books to loan.")
                    continue
                }

                val borrower = readBorrowerInfo()
                library.createLoan(borrower)
            }
            MainMenuOption.DISPLAY_ALL_LOANS -> {
                loanManager.getAllLoans().forEach { loan ->
                    println("${loan.book.title} (Due on: ${loan.dueDate})")
                }
                library.displayAllLoans()
            }

            MainMenuOption.EXIT -> {
                println("Thank you for using the library management system!")
                return
            }
            null -> continue
        }
    }
}

