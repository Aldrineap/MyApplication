package com.alarcon.myapplication.exercise10

abstract class Car (
    val maker: String,
    val model: String,
    val year: Int,
    val price : Double
)
{
        abstract fun calculateVal() : Double
}