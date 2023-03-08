package com.alarcon.myapplication.Class

data  class LibraryBook(
    val book: Book,
    var status: BookStatus = BookStatus.AVAILABLE
)
