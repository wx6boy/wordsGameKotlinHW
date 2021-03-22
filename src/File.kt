import java.io.File
import kotlin.random.Random

private const val PATH = "src/words/words.txt"
private const val WRITTEN_WORDS_PATH = "src/words/my_words.txt"

fun getListOfWordsFromFile(): List<String>{
    val bufferedReader = File(PATH).bufferedReader()
    return bufferedReader.use { it.readLines() }.map { it.toLowerCase() }
}

fun getRandomWordFromFile(length: Int): String{
    val longWords = getListOfWordsFromFile().filter { it.length >= length }
    val randomNumber = Random.nextInt(0, longWords.size)
    return longWords[randomNumber]
}

fun getMyWords(): List<String>{
    val bufferedReader = File(WRITTEN_WORDS_PATH).bufferedReader()
    return bufferedReader.use { it.readLines() }.map { it.toLowerCase() }
}

fun saveWordsToFile(words: List<String>){
    val file = File(WRITTEN_WORDS_PATH)
    file.printWriter().use{ out ->
        for (word in words){
            out.println(word)
        }
    }
}
