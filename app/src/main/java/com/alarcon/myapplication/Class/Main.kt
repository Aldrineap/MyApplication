package com.alarcon.myapplication.Class


fun main() {
    val library = Library()
    val libraryLoan = LibraryLoan()

    while (true) {
        displayMainMenu()
        val userInput = readMainMenuChoice()
        when (userInput) {
            MainMenuOption.ADD_BOOK -> {
                library.addBook()
            }
            MainMenuOption.REMOVE_BOOK -> {
                library.removeBook()
            }
            MainMenuOption.DISPLAY_ALL_BOOKS -> {
                val allBooks = library.getAllBooks()
                library.displayAllBooks(allBooks)
            }
            MainMenuOption.CREATE_LOAN -> {
                val loan = library.createLoan()
                if (loan != null) {
                    libraryLoan.addLoan(loan)
                }
            }
            MainMenuOption.DISPLAY_ALL_LOANS -> {
                val allLoans = libraryLoan.getAllLoans()
                library.displayAllLoans(allLoans)
            }
            MainMenuOption.EXIT -> {
                println("Exiting program. Goodbye!")
                return
            }
            else -> {
                println("Invalid input. Please try again.")
            }
        }
        println()
    }
}

