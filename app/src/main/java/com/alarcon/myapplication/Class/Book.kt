package com.alarcon.myapplication.Class

import java.time.LocalDate



 class Book(
     val title: String,
     val author: String,
     val publicationDate: LocalDate,
     var available: Boolean = true
 ) {


    override fun toString(): String {
    println ("\n==============================================")
        return "Title: $title\nAuthor: $author\nPublication Date: $publicationDate"
            }


}
