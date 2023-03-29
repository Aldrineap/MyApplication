package com.alarcon.myapplication.exercise10

class CarDealer {

    val availableCars = mutableListOf<Car>()
    val purchasedCars = mutableListOf<Purchase>()
    val returnedCars = mutableListOf<Return>()

    fun addCar(car: Car) {
        availableCars.add(car)
    }

    fun removeCar(car: Car) {
        availableCars.remove(car)
    }

    fun purchaseCar(customer: Customer, car: Car, paymentMethod: PaymentType): String {
        val purchasePrice = car.calculateVal()

        return if (availableCars.contains(car) && customer.budget >= purchasePrice) {
            removeCar(car)
            purchasedCars.add(
                Purchase(
                    customer = customer,
                    car = car,
                    paymentMethod = paymentMethod,
                    purchasePrice = purchasePrice
                )
            )
            customer.budget -= purchasePrice
            "${customer.name} has purchased a ${car.maker} ${car.model} for $purchasePrice using $paymentMethod."
        } else {
            "${customer.name} cannot purchase a ${car.maker} ${car.model}."
        }
    }

    fun returnCar(customer: Customer, car: Car): String {
        val returnPrice = car.calculateVal()

        return if (purchasedCars.any { it.car == car }) {
            purchasedCars.removeIf { it.car == car }
            returnedCars.add(
                Return(
                    customer = customer,
                    car = car,
                    returnPrice = returnPrice
                )
            )
            customer.budget += returnPrice
            addCar(car)
            "${customer.name} has returned a ${car.maker} ${car.model} and received $returnPrice."
        } else {
            "${customer.name} cannot return a ${car.maker} ${car.model}."
        }
    }
}
