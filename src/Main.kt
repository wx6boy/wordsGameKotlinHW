import kotlinx.coroutines.*


fun main(){
    runBlocking{
        val words = getListOfWordsFromFile()
        val randomWord = getRandomWordFromFile(10)
        println("Случайное слово: $randomWord")
        saveWordsToFile(readLine()!!.getInputWords())
        val myWords = getMyWords()
        launch(Dispatchers.Default){
            val gameScore = async{
                getScore(myWords, words, randomWord)
            }
            println("Результат: ${gameScore.await()}")
        }
    }
}

suspend fun getScore(
    inputWords: List<String>,
    words_dictionary: List<String>,
    longWord: String) = coroutineScope{
    var gameScore = 0
    for (current_word in inputWords){
        if (longWord.contains(current_word, true)){
            if (words_dictionary.find { current_word == it } != null){
                gameScore += current_word.length
            }
        }
    }
    gameScore
}