package com.alarcon.myapplication.Class

enum class MainMenuOption {
    ADD_BOOK,
    REMOVE_BOOK,
    DISPLAY_ALL_BOOKS,
    CREATE_LOAN,
    DISPLAY_ALL_LOANS,
    EXIT


}
fun readMainMenuChoice(): MainMenuOption? {
    print("Enter your choice: ")
    val userInput = readLine()?.toIntOrNull()
    return when (userInput) {
        1 -> MainMenuOption.ADD_BOOK
        2 -> MainMenuOption.REMOVE_BOOK
        3 -> MainMenuOption.DISPLAY_ALL_BOOKS
        4 -> MainMenuOption.CREATE_LOAN
        5 -> MainMenuOption.DISPLAY_ALL_LOANS
        6 -> MainMenuOption.EXIT
        else -> null
    }
}

fun readBorrowerInfo(): Borrower? {
    println("Creating borrower...")
    print("Library card number: ")
    val libraryCardNumber = readLine() ?: ""
    print("Name: ")
    val name = readLine() ?: ""
    print("Phone number: ")
    val phone = readLine() ?: ""
    return Borrower(libraryCardNumber, name, phone)
}

fun displayMainMenu() {
    println("=== Main Menu ===")
    println("1. Add book")
    println("2. Remove book")
    println("3. Display all books")
    println("4. Create loan")
    println("5. Display all loans")
    println("6. Exit")
}