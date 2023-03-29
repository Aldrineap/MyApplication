package com.alarcon.myapplication.Class

import java.time.LocalDate


data class loan(

    var book: Book,
    var borrower: Borrower,
    var dueDate: LocalDate,
    var returnDate: LocalDate?= null


)
