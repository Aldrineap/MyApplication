package com.alarcon.myapplication.exercise10

class SportsCar(
    maker: String,
    model: String,
    year: Int,
    price: Double
) : Car(maker, model, year, price) {
    override fun calculateVal(): Double {
        return price * 0.9

    }
}