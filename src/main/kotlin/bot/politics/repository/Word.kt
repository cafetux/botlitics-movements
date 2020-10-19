package bot.politics.repository

import kotlinx.serialization.Serializable

@Serializable
data class Word(val category: String, val whenFirst: String, val whenSecond: String, val sloganStart: List<String>, val sloganEnd:List<String>)