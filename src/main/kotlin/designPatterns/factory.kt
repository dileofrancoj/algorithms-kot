package org.example.designPatterns

enum class AnimalType {
    DOG, CAT
}

interface Animal {
    fun makeSound(): String
}
class Dog: Animal {
    override fun makeSound(): String {
        return "Guau"
    }
}

class Cat: Animal {
    override fun makeSound() = "Miau"
}

fun animalFactory(type: AnimalType): Animal {
    val animal = when(type) {
        AnimalType.DOG -> Dog()
        AnimalType.CAT -> Cat()
    }
    return animal
}


fun animalDemo() {
    val someDog = animalFactory(AnimalType.DOG)
    someDog.makeSound()
}

interface Vehicle {
    fun drive() : String
}

class Car: Vehicle {
    override fun drive() = "Driving car"
}

class Bike: Vehicle {
    override fun drive() = "Driving a bike"
}

// La instancia a través de un object de kotlin es única
object VehicleFactory {
 fun create(type: String): Vehicle {
     return when(type) {
         "car" -> Car()
         "bike" -> Bike()
         else -> throw IllegalArgumentException("Vehicle type is not supported")
     }
 }
}

fun demoVehicle() {
    val car = VehicleFactory.create("car")
    car.drive()
}

// sealed class para productos limitados

sealed class Shape {
    data class Circle(val radius: Double): Shape()
    data class Square(val side: Double): Shape()
    data class Rectangle(val width: Double, val height: Double): Shape()
}

object ShapeFactory {
    fun create(type: String, vararg dimensions: Double): Shape {
        return when (type) {
            "circle" -> {
                val radius = dimensions.getOrNull(0) ?: throw IllegalArgumentException("Circle accepts one argument (radius)")
                Shape.Circle(radius)
            }
            "square" -> {
                val side = dimensions.getOrNull(0) ?: throw IllegalArgumentException("Square accepts one argument (side)")
                Shape.Square(side)
            }
            "rectangle" -> {
                val width = dimensions.getOrNull(0) ?: throw IllegalArgumentException("Square accepts one argument (side)")
                val height = dimensions.getOrNull(1) ?: throw IllegalArgumentException("Square accepts one argument (side)")
                Shape.Rectangle(width,height)
            }
            else -> throw IllegalArgumentException("Shape is not allowed")
        }
    }
}

fun shapeDemo() {
    val circle = ShapeFactory.create("circle", 4.0)
    val rectangle = ShapeFactory.create("rectangle", 4.0, 6.0)
}

// Nuevo ejemplo con ShapeFactory pero sin data class
sealed class Shape2 {
    abstract fun area(): Double // cada uno tendrá su implementación

    class Circle(private val radius: Double): Shape2() {
        override fun area(): Double {
            return Math.PI * radius * radius
        }
    }

    class Square(private val side: Double): Shape2() {
        override fun area(): Double {
            return side * side
        }
    }
    class Rectangle(private val width: Double, private val height: Double): Shape2() {
        override fun area(): Double {
            return width * height
        }
    }
}

object ShapeFactory2 {
    fun create(type: String, vararg dimensions: Double): Shape2 {
        return when (type) {
            "circle" -> {
                val radius = dimensions.getOrNull(0) ?: throw IllegalArgumentException("Not allowed")
                Shape2.Circle(radius)
            }

            "square" -> {
                val side =
                    dimensions.getOrNull(0) ?: throw IllegalArgumentException("Square accepts one argument (side)")
                Shape2.Square(side)
            }

            "rectangle" -> {
                val width =
                    dimensions.getOrNull(0) ?: throw IllegalArgumentException("Square accepts one argument (side)")
                val height =
                    dimensions.getOrNull(1) ?: throw IllegalArgumentException("Square accepts one argument (side)")
                Shape2.Rectangle(width, height)
            }

            else -> throw IllegalArgumentException("Shape is not allowed")
        }
    }
}

fun shape2Demo() {
    val circle = ShapeFactory2.create("circle", 4.0)
    val rectangle = ShapeFactory2.create("rectangle", 4.0, 6.0)
}
