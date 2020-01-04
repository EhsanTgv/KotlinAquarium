import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")
    feedTheFish()

    var bubble = 0
    while (bubble < 50) {
        bubble++
    }

    repeat(2) {
        println("A fish is swimming")
    }
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

var dirty = 20

val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }

fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) { dirty ->
        dirty + 50
    }
}

fun isTooHot(temperature: Int): Boolean = temperature > 30

fun isDirty(dirty: Int): Boolean = dirty > 30

fun isSunday(day: String): Boolean = day == "Sunday"

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }

    swim("Slow")

    dirtyProcessor()
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redWorms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}