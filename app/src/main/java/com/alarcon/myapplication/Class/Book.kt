package com.alarcon.myapplication.Class

import java.time.LocalDate


//    override fun toString(): String {
//    println ("\n==============================================")
//        return "Title: $title\nAuthor: $author\nPublication Date: $publicationDate"
//            }
abstract class Book(
    var title: String,
    var author: String,
    var publicationDate: LocalDate,
    var status: BookStatus
)