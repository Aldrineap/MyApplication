package com.alarcon.myapplication.Class

class LibraryLoan {
    private val loans = mutableListOf<loan>()
    fun addLoan(loan: loan) {
        loans.add(loan)
    }

    fun getAllLoans(): List<loan> {
        return loans.toList()
    }

}