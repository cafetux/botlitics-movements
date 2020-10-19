package bot.politics

import bot.politics.repository.Word
import bot.politics.repository.getCandidats
import kotlin.random.Random


fun generateRandomMovement() : String {
    val candidats = getCandidats()
    val firstPart = candidats.filter { !it.whenFirst.isBlank() }.random()
    val secondPart = candidats.filter { it.category!=firstPart.category }.random()
    return "${firstPart.whenFirst}-${secondPart.whenSecond}: ${sentence(firstPart, secondPart)}"
}

private fun sentence(firstPart: Word, secondPart: Word): String {
    return if(Random.nextBoolean()){
        "Pour ${firstPart.sloganStart.random()} ${secondPart.sloganEnd.random()}"
    } else {
        "Pour ${secondPart.sloganStart.random()} ${firstPart.sloganEnd.random()}"
    }
}
