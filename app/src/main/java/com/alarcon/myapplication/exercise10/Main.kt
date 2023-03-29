package com.alarcon.myapplication.exercise10

fun main() {

    val dealership = CarDealer()

    // Populate the dealership with some initial cars
    val car1 = SportsCar("Ferrari", "F8 Tributo", 2021, 250000.0)
    val car2 = SUV(maker = "Toyota", model = "Highlander", year = 2020, price = 30000.0)
    val car3 = Truck(maker = "Ford", model = "F-150", year = 2015, price = 25000.0)

    dealership.addCar(car1)
    dealership.addCar(car2)
    dealership.addCar(car3)

    // Prompt the user for their information
    print("Enter your name: ")
    val name = readLine()!!
    print("Enter your age: ")
    val age = readLine()!!.toInt()
    print("Enter your budget: ")
    val budget = readLine()!!.toDouble()

    val customer = Customer(name, age, budget)

    while (true) {
        // Display the list of available cars
        println("Available cars:")
        for ((index, car) in dealership.availableCars.withIndex()) {
            println("${index + 1}. ${car.maker} ${car.model} (${car.year}) - $${car.price}")
        }

        // Prompt the user to select a car
        print("Enter the number of the car you want to purchase (or type 'exit' to quit): ")
        val input = readLine()!!

        if (input == "exit") {
            break
        }

        val selectedCar: Car? = if (input.toIntOrNull() != null) {
            val index = input.toInt() - 1
            dealership.availableCars.getOrNull(index)
        } else {
            dealership.availableCars.find {
                "${it.maker} ${it.model}" == input
            }
        }

        if (selectedCar == null) {
            println("Invalid car selection.")
            continue
        }

        // Prompt the user to select a payment method
        var paymentMethod: PaymentType? = null
        while (paymentMethod == null) {
            // Prompt the user to select a payment method
            println("Purchase price: $${selectedCar.calculateVal()}")
            print("Select a payment method (C for cash, CC for credit card, BT for bank transfer): ")

            val input = readLine()?.toUpperCase()

            paymentMethod = when (input) {
                "C" -> PaymentType.CASH
                "CC" -> PaymentType.CREDIT_CARD
                "BT" -> PaymentType.BANK_TRANSFER
                else -> null
            }

            if (paymentMethod == null) {
                println("Invalid payment method.")
            }
        }

        // Attempt to purchase the car
        val result = dealership.purchaseCar(customer, selectedCar, paymentMethod)

        println(result)

        // Ask the user if they want to select another car
        print("Do you want to select another car? (y/n): ")
        val selectAnotherCar = readLine()!!.toLowerCase()

        if (selectAnotherCar == "n") {
            break
        }
    }
}

//    while (true) {
//        // Display the list of available cars
//        println("Available cars:")
//        for ((index, car) in dealership.availableCars.withIndex()) {
//            println("${index + 1}. ${car.maker} ${car.model} (${car.year}) - $${car.price}")
//        }
//
//        // Prompt the user to select a car
//        print("Enter the number of the car you want to purchase (or type 'exit' to quit): ")
//        val input = readLine()!!
//
//        if (input == "exit") {
//            break
//        }
//
//        val selectedCar: Car? = if (input.toIntOrNull() != null) {
//            val index = input.toInt() - 1
//            dealership.availableCars.getOrNull(index)
//        } else {
//            dealership.availableCars.find {
//                "${it.maker} ${it.model}" == input
//            }
//        }
//
//        if (selectedCar == null) {
//            println("Invalid car selection.")
//            continue
//        }
//
//        // Prompt the user to select a payment method
//        println("Purchase price: $${selectedCar.calculateVal()}")
//        print("Select a payment method (CASH, CREDIT_CARD, BANK_TRANSFER): ")
//        val paymentMethod = PaymentType.valueOf(readLine()!!.toUpperCase())
//
//        // Attempt to purchase the car
//        val result = dealership.purchaseCar(customer, selectedCar, paymentMethod)
//
//        println(result)
//
//        // Ask the user if they want to select another car
//        print("Do you want to select another car? (y/n): ")
//        val selectAnotherCar = readLine()!!.toLowerCase()
//
//        if (selectAnotherCar == "n") {
//            break
//        }
//    }
//}


