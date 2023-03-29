package com.alarcon.myapplication.Class

import java.time.LocalDate
import java.util.*


class Library {
    private val books = mutableListOf<LibraryBook>()
    private val loans = mutableListOf<loan>()

    fun addBook() {
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

        val book = object : Book(title, author, publicationDate, BookStatus.AVAILABLE) {}
        books.add(LibraryBook(book, BookStatus.AVAILABLE))

        print("Book added successfully! Add another book? (y/n): ")
        val input = readLine()?.trim()?.lowercase(Locale.getDefault())
        if (input == "y") {
            addBook()
        }
    }


    fun removeBook() {
        if (books.isEmpty()) {
            println("There are no books in the library.")
            return
        }

        println("\nRemove a book:\n")

        print("Enter the book title or author to remove : ")
        val searchKey = readLine()?.toLowerCase()?.trim()

        val matchingBooks = books.filter {
            it.book.title.toLowerCase().contains(searchKey ?: "") ||
                    it.book.author.toLowerCase().contains(searchKey ?: "")
        }

        if (matchingBooks.isEmpty()) {
            println("No books found matching \"$searchKey\".")
            return
        }

        println("Found ${matchingBooks.size} book(s):")

        for ((index, book) in matchingBooks.withIndex()) {
            println("${index + 1}. ${book.book.title} by ${book.book.author} (${book.book.publicationDate}) - ${book.status}")
        }

        print("Enter the number of the book to remove: ")
        val input = readLine()?.toIntOrNull() ?: return

        if (input < 1 || input > matchingBooks.size) {
            println("Invalid input. Please try again.")
            return
        }

        val book = matchingBooks[input - 1]

        if (book.status == BookStatus.ON_LOAN) {
            println("This book is currently on loan and cannot be removed.")
            return
        }

        books.remove(book)
        println("${book.book.title} by ${book.book.author} has been removed from the library.")
    }

    fun displayAllBooks() {
        if (books.isEmpty()) {
            println("There are no books in the library.")
            return
        }

        println("\nDisplay all books:\n")

        print("Enter the book title or author to display for: ")
        val searchKey = readLine()?.toLowerCase()?.trim()

        val matchingBooks = books.filter {
            it.book.title.toLowerCase().contains(searchKey ?: "") ||
                    it.book.author.toLowerCase().contains(searchKey ?: "")
        }

        if (matchingBooks.isEmpty()) {
            println("No books found matching \"$searchKey\".")
            return
        }

        println("Found ${matchingBooks.size} book(s):")

        for ((index, book) in matchingBooks.withIndex()) {
            println("${index + 1}. ${book.book.title} by ${book.book.author} (${book.book.publicationDate}) - ${book.status}")
        }
    }

    fun createLoan(borrower: Borrower) {
        println("\nCreate a loan:\n")

        print("Enter the book title or author to borrow : ")
        val searchKey = readLine()?.toLowerCase()?.trim()

        val availableBooks = getAllBooks(BookStatus.AVAILABLE).filter {
            it.title.toLowerCase().contains(searchKey ?: "") ||
                    it.author.toLowerCase().contains(searchKey ?: "")
        }

        if (availableBooks.isEmpty()) {
            println("No books found matching \"$searchKey\".")
            return
        }

        println("Found ${availableBooks.size} available book(s):")

        for ((index, book) in availableBooks.withIndex()) {
            println("${index + 1}. ${book.title} by ${book.author} (${book.publicationDate})")
        }

        print("Enter the number of the book to loan: ")
        val input = readLine()?.toIntOrNull() ?: return

        if (input < 1 || input > availableBooks.size) {
            println("Invalid input. Please try again.")
            return
        }

        val selectedBook = availableBooks[input - 1]

        val loan = loan(selectedBook, borrower, LocalDate.now().plusWeeks(2))
        loans.add(loan)

        val libraryBook = books.find { it.book == selectedBook } ?: return
        libraryBook.status = BookStatus.ON_LOAN

        println("${borrower.name} has borrowed ${selectedBook.title}. It is due on ${loan.dueDate}.")
    }



    fun displayAllLoans() {
        if (loans.isEmpty()) {
            println("There are no loans in the library.")
            return
        }

        println("\nLibrary loans:\n")
        for (loan in loans) {
            val book = loan.book
            val borrower = loan.borrower
            val status = if (loan.returnDate != null) "Returned" else "On loan"
            val returnDate = loan.returnDate ?: "Not returned yet"

            println("${book.title} by ${book.author} (${book.publicationDate}) " +
                    "borrowed by ${borrower.name} (Library Card Number: ${borrower.libraryCardNumber}) " +
                    "due on ${loan.dueDate} - $status (Return Date: $returnDate)")
        }
        println()
    }


    fun getAllBooks(status: BookStatus? = null): List<Book> {
        return if (status == null) {
            books.map { it.book }.toList()
        } else {
            books.filter { it.status == status }.map { it.book }.toList()
        }
    }


}