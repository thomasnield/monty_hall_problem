import java.util.concurrent.ThreadLocalRandom

/**
 * Monty Hall Problem Simulation
 */

fun randomDoor() = ThreadLocalRandom.current().nextInt(0,3)

// how many trials do you want to run?
val trialCount = 10000

var stayWins = 0
var switchWins = 0

repeat(trialCount) {
    val prizeDoor = randomDoor()
    val selectedDoor = randomDoor()

    val openedDoor = (0..2).shuffled().first { d -> d != selectedDoor && d != prizeDoor }
    val switchedDoor = (0..2).shuffled().first { d -> d != selectedDoor && d != openedDoor }

    if (selectedDoor == prizeDoor) stayWins++
    if (switchedDoor == prizeDoor) switchWins++
}

println("STAY WIN RATE: ${stayWins.toDouble() / trialCount.toDouble()}")
println("SWITCH WIN RATE: ${switchWins.toDouble() / trialCount.toDouble()}")
