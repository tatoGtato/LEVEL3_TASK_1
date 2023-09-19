package com.example.level3_task_1

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.level3_task_1.ui.theme.LEVEL3_TASK_1Theme
import com.example.level3_task_1.ui.theme.screens.GameRatingScreen
import com.example.level3_task_1.ui.theme.screens.GameRatingScreens
import com.example.level3_task_1.ui.theme.screens.GameRatingStartScreen
import com.example.level3_task_1.ui.theme.screens.GameRatingSummaryScreen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LEVEL3_TASK_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    ReviewsNavHost(navController = navController, modifier = Modifier)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun ReviewsNavHost(
    navController: NavHostController, modifier: Modifier
) {
    val viewModel: GameViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = GameRatingScreens.StartScreen.name,
        modifier = modifier
    ){
        composable(GameRatingScreens.StartScreen.name) {
            GameRatingStartScreen(navController, viewModel)
        }
        composable(GameRatingScreens.RatingScreen.name) {
            GameRatingScreen(navController, viewModel)
        }
        composable(GameRatingScreens.SummaryScreen.name) {
            GameRatingSummaryScreen(navController, viewModel)
        }
    }
}
