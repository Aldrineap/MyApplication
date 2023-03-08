package com.alarcon.myapplication.Class


class LibraryLoan {
    private val loans = mutableListOf<Loan>()

    fun addLoan(loan: Loan) {
        loans.add(loan)
    }

    fun getAllLoans(): List<Loan> {
        return loans.toList()
    }
}

