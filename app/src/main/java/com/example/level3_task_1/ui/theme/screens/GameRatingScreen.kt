package com.example.level3_task_1.ui.theme.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.level3_task_1.GameViewModel
import com.example.level3_task_1.R
import com.example.level3_task_1.ui.theme.bit
import com.example.level3_task_1.ui.theme.bitb
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameRatingScreen(navController: NavHostController, viewModel: GameViewModel) {
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

        content = {innerPadding -> RatingScreen(Modifier.padding(innerPadding), navController, viewModel)

        },
    )
}

@Composable
fun RatingScreen(padding: Modifier, navController: NavHostController, viewModel: GameViewModel) {
    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = context.getString(R.string.rate_game),
                fontFamily = bitb,
                color = Color(0,30,49),
                textAlign = TextAlign.Center)
        }
        Row (
            modifier = Modifier.padding(10.dp)
        ){
            Image(
                painter = painterResource(id = viewModel.randomlyChosenGame.value.img),
                contentDescription = "", // decorative element
                modifier = Modifier
                    .padding(end = 5.dp)
            )
        }
        Row (
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = viewModel.randomlyChosenGame.value.name,
                fontFamily = bit,
                color = Color(0,30,49))
        }
        Row {
            RatingBar(
                value = viewModel.gameRatingAccordingToUser.value,
                stepSize = StepSize.HALF,
                style = RatingBarStyle.Fill(),
                onValueChange = {
                    viewModel.gameRatingAccordingToUser.value = it
                },
                onRatingChanged = {
                    Log.d("TAG", "onRatingChanged: $it")
                }
            )
        }
        Row {
            Button(
                modifier = Modifier
                    .padding(20.dp)
                    .height(50.dp),
                shape = CutCornerShape(20),
                colors = ButtonDefaults.buttonColors(Color(252, 191, 73)),
                border = BorderStroke(width = 3.dp, color = Color(0, 48, 73)),
                onClick = {
                    navController.navigate(GameRatingScreens.SummaryScreen.name)
                }
            ){
                Text(text = context.getString(R.string.to_summary),
                    color = Color(0, 48, 73),
                    fontFamily = bit,)
            }
        }
    }
}