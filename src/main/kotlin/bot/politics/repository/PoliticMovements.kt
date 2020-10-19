package bot.politics.repository

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

fun getCandidats(): List<Word> {
    return loadFromJsonFile("datas.json")
}

private fun loadFile(fileName: String) = File(ClassLoader.getSystemResource(fileName).toURI())
private fun loadFromJsonFile(fileName: String) = Json.decodeFromString<List<Word>>(File(ClassLoader.getSystemResource(fileName).toURI()).readText())


