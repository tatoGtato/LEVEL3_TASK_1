package com.example.level3_task_1

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {


    data class Game(
        val name: String,
        val img: Int,
    )

    // Randomly chosen game from a list of games.
    val randomlyChosenGame = mutableStateOf(Game("",0))

    // Rating provided by the user.
    // Initial value is 5 star rating (5 floating)
    var gameRatingAccordingToUser = mutableStateOf(5f)

    fun randomAssessableGame(){
        randomlyChosenGame.value = listOf(
            Game("Red Dead Redemption 2", R.drawable.red),
            Game("Rocket League", R.drawable.rocket),
            Game("Shadow of the Tombraider", R.drawable.tomb)
        ).random()
    }


    fun reset() {
        randomlyChosenGame.value = Game("",0)
        gameRatingAccordingToUser.value = 5f
    }
}