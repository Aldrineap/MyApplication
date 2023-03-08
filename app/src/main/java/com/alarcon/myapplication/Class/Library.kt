package com.alarcon.myapplication.Class

import java.time.LocalDate
import java.time.format.DateTimeParseException

class Library {
    private val libraryBooks = mutableListOf<LibraryBook>()
    //private val loans = mutableListOf<loans>()
    fun addBook() {
        println("Adding book...")
        print("Title: ")
        val title = readLine() ?: ""
        print("Author: ")
        val author = readLine() ?: ""
        print("Publication date (mm/dd/yyyy): ")
        val publicationDate = readLine() ?: ""
        val dateParts = publicationDate.split("/")
        if (dateParts.size != 3) {
            println("Invalid date format. Please use the mm/dd/yyyy format.")
            return
        }
        val month = dateParts[0].toIntOrNull()
        val day = dateParts[1].toIntOrNull()
        val year = dateParts[2].toIntOrNull()
        if (month == null || day == null || year == null) {
            println("Invalid date format. Please use the mm/dd/yyyy format.")
            return
        }
        val book = Book(title, author, publicationDate = LocalDate.of(year, month, day))
        val libraryBook = LibraryBook(book)
        libraryBooks.add(libraryBook)
        println("Book added successfully.")
    }


    fun removeBook() {
        print("Enter the title of the book to remove: ")
        val title = readLine() ?: ""
        val libraryBook = libraryBooks.find { it.book.title == title }
        if (libraryBook != null) {
            libraryBooks.remove(libraryBook)
            println("Book removed successfully.")
        } else {
            println("Book not found.")
        }
    }

    fun getAllBooks(): List<LibraryBook> {
        return libraryBooks.toList()
    }

    fun createLoan(): Loan? {
        println("Creating loan...")
        val libraryBook = selectAvailableBook()
        if (libraryBook == null) {
            println("No books available to loan.")
            return null
        }
        val borrower = readBorrowerInfo() ?: return null
        if (borrower.libraryCardNumber.isEmpty() || borrower.name.isEmpty() || borrower.phone.isEmpty()) {
            println("Invalid borrower information. Please try again.")
            return null
        }
        print("Due date (yyyy-mm-dd): ")
        val dueDate = readLine() ?: ""
        val loanDueDate = try {
            LocalDate.parse(dueDate)
        } catch (ex: DateTimeParseException) {
            println("Invalid date format. Please try again.")
            return null
        }
        val loan = Loan(
            libraryBook.book,
            borrower,
            loanDueDate
        )
        libraryBook.status = BookStatus.ON_LOAN
        println("Loan created successfully.")
        return loan
    }

    private fun selectAvailableBook(): LibraryBook? {
        val availableBooks = libraryBooks.filter { it.status == BookStatus.AVAILABLE }
        if (availableBooks.isEmpty()) {
            return null
        }
        println("Select a book to loan:")
        availableBooks.forEachIndexed { index, libraryBook ->
            println("${index + 1}. ${libraryBook.book.title} by ${libraryBook.book.author}")
        }
        val userInput = readLine()?.toIntOrNull() ?: return null
        if (userInput < 1 || userInput > availableBooks.size) {
            return null
        }
        return availableBooks[userInput - 1]
    }

    fun displayAllBooks(books: List<LibraryBook>) {
        if (books.isNotEmpty()) {
            println("=== All Books ===")
            books.forEach { println(it.book) }
        } else {
            println("No books found in the library.")
        }
    }

    fun displayAllLoans(loans: List<Loan>) {
        if (loans.isNotEmpty()) {
          //  val sortedLoans = loans.sortedWith(compareBy(Loan::dueDate, Loan::borrowername))
            val sortedLoans = loans.sortedBy { it.dueDate }
            println("=== All Loans ===")
            sortedLoans.forEach { println(it) }
        } else {
            println("No loans found in the library.")
        }
    }
}
