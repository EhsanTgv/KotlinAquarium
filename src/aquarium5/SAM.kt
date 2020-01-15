package aquarium5

interface Runnable {
    fun run()
}

interface Callable<T> {}

fun example() {
    val runnable = object : Runnable {
        override fun run() {
            println("I'm a runnable")
        }
    }
    JavaRun.runNow(runnable)
}