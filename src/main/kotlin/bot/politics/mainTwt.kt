package bot.politics

import twitter4j.Twitter
import twitter4j.TwitterException
import twitter4j.TwitterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

private val scheduler = Executors.newScheduledThreadPool(1)
private val twitter: Twitter = TwitterFactory.getSingleton()
private val intros = listOf(
    "Aujourd'hui, le mouvement:",
    "Découvrons un mouvement politique:",
    "Avez vous essayé le:",
    "Connaissez vous le courant:",
    "Qui sont les:"
)

fun main() {
    scheduler.scheduleAtFixedRate({post(generateRandomMovement())}, 0, 3, TimeUnit.HOURS)
}

fun post(toPost: String) {
    try {
        twitter.updateStatus("${intros.random()}\n"+toPost.trimIndent())
    } catch (e: TwitterException) {
        e.printStackTrace()
    }
}
