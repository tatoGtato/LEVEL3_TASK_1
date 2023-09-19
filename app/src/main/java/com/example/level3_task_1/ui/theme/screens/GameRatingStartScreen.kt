package com.example.level3_task_1.ui.theme.screens

import android.os.Build
import android.widget.Toast
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
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.level3_task_1.GameViewModel
import com.example.level3_task_1.R
import com.example.level3_task_1.ui.theme.bit
import com.example.level3_task_1.ui.theme.bitb


@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameRatingStartScreen(navController: NavHostController, viewModel: GameViewModel) {
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

        content = {innerPadding -> StartScreen(Modifier.padding(innerPadding), navController, viewModel)

        },
    )
}

@Composable
fun StartScreen(padding: Modifier, navController: NavHostController, viewModel: GameViewModel) {
    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxSize().padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            Text(text = context.getString(R.string.welcome),
                fontFamily = bitb,
                color = Color(0,30,49))
        }
        Row {
            Text(text = context.getString(R.string.click_start),
                fontFamily = bit,
                color = Color(247, 127, 0))
        }
        Row {
            Button(
                modifier = Modifier
                    .padding(20.dp)
                    .height(50.dp)
                    .width(110.dp),
                shape = CutCornerShape(20),
                colors = ButtonDefaults.buttonColors(Color(252, 191, 73)),
                border = BorderStroke(width = 3.dp, color = Color(0, 48, 73)),
                onClick = {
                    viewModel.randomAssessableGame()
                    navController.navigate(GameRatingScreens.RatingScreen.name)
                },

            ){
                Text(text = context.getString(R.string.start),
                    color = Color(0, 48, 73),
                    fontFamily = bit,)
            }
        }
    }
}
