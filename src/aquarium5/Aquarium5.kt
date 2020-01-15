package aquarium5

data class Fish(var name: String)

fun main(args: Array<String>) {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

    myWith(fish.name, object : Function1<String, Unit> {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })

    fish.name.capitalize()

    println(fish.run { name })
    println(fish.apply {})

    val fish2 = Fish(name = "splashy").apply { name = "Shark" }
    println(fish2.name)

    fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 }
}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}
