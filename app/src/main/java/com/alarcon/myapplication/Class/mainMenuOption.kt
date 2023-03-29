package com.alarcon.myapplication.Class

import java.time.LocalDate

enum class MainMenuOption {
    ADD_BOOK,
    REMOVE_BOOK,
    DISPLAY_ALL_BOOKS,
    CREATE_LOAN,
    DISPLAY_ALL_LOANS,
    EXIT
}

fun displayMainMenu() {
    println("Main Menu:\n")
    println("1. Add a book")
    println("2. Remove a book")
    println("3. Display all books")
    println("4. Create a loan")
    println("5. Display all loans")
    println("6. Exit")
}

fun readMainMenuOption(): MainMenuOption? {
    print("Enter the number of your choice: ")
    val input = readLine()?.toIntOrNull()

    return when (input) {
        1 -> MainMenuOption.ADD_BOOK
        2 -> MainMenuOption.REMOVE_BOOK
        3 -> MainMenuOption.DISPLAY_ALL_BOOKS
        4 -> MainMenuOption.CREATE_LOAN
        5 -> MainMenuOption.DISPLAY_ALL_LOANS
        6 -> MainMenuOption.EXIT
        else -> {
            println("Invalid option. Please try again.")
            readMainMenuOption()
        }
    }
}

fun readBookInfo(): Book {
    var title: String
    var author: String
    var publicationDate: LocalDate

    do {
        print("Enter the book title: ")
        title = readLine() ?: ""
    } while (title.isBlank())

    do {
        print("Enter the author name: ")
        author = readLine() ?: ""
    } while (author.isBlank())

    do {
        print("Enter the publication date (yyyy-mm-dd): ")
        publicationDate = try {
            LocalDate.parse(readLine())
        } catch (e: Exception) {
            LocalDate.now()
        }
    } while (publicationDate == LocalDate.now())

    return object : Book(title, author, publicationDate, BookStatus.AVAILABLE) {}

}
fun readBorrowerInfo(): Borrower {
    var libraryCardNumber: String
    var name: String
    var phone: String

    do {
        print("Enter the borrower's library card number: ")
        libraryCardNumber = readLine() ?: ""
    } while (libraryCardNumber.isBlank())

    do {
        print("Enter the borrower's name: ")
        name = readLine() ?: ""
    } while (name.isBlank())

    do {
        print("Enter the borrower's phone number: ")
        phone = readLine() ?: ""
    } while (phone.isBlank())

    return Borrower(libraryCardNumber, name, phone)
}

