package com.example.level3_task_1.ui.theme.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.level3_task_1.GameViewModel
import com.example.level3_task_1.R
import com.example.level3_task_1.ui.theme.bit
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameRatingSummaryScreen(navController: NavHostController, viewModel: GameViewModel) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = context.getString(R.string.app_name),
                        fontFamily = bit,
                        color = Color(252, 191, 73)
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0,30,49))
            )
        },

        content = {innerPadding -> SummaryScreen(Modifier.padding(innerPadding), navController, viewModel)

        },
    )
}

@Composable
fun SummaryScreen(padding: Modifier, navController: NavHostController, viewModel: GameViewModel) {
    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = context.getString(R.string.rate_result,
                viewModel.randomlyChosenGame.value.name,
                viewModel.gameRatingAccordingToUser.value.toString()),
                fontFamily = bit,
                textAlign = TextAlign.Center)
        }
        Row {
            Button(
                modifier = Modifier
                    .padding(20.dp),
                shape = CutCornerShape(20),
                colors = ButtonDefaults.buttonColors(Color(252, 191, 73)),
                border = BorderStroke(width = 3.dp, color = Color(0, 48, 73)),
                onClick = {
                    navController.popBackStack(route = GameRatingScreens.StartScreen.name,
                                               inclusive = false)
                    viewModel.reset()
                }
            ){
                Text(text = context.getString(R.string.start_over),
                    color = Color(0, 48, 73),
                    fontFamily = bit)
            }
        }
    }
}