package com.alarcon.myapplication.Class
data class Borrower(
    var libraryCardNumber: String,
    override var name: String,
    override var phone: String
) : Person