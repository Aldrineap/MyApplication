package com.alarcon.myapplication.Class

import java.time.LocalDate



data class Loan(
    val book: Book,
    val borrower: Borrower,
    val dueDate: LocalDate
) {
    override fun toString(): String {
        return "Book: ${book.title}, Borrower: ${borrower.name}, Due date: ${dueDate}"
    }
}

