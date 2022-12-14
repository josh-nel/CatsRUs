package com.example.pawsfromheaven

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pawsfromheaven.data.PetList
import com.example.pawsfromheaven.ui.screen.DetailScreen
import com.example.pawsfromheaven.ui.screen.HomeScreen
import com.example.pawsfromheaven.ui.theme.PAWSFromHeavenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAWSFromHeavenTheme {
                MyApp()
            }
        }
    }
}

@Composable

fun MyApp(){
//Setting up a navController
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        //Making each screen composable
        composable(route = "home"){
            HomeScreen(navController)
        }
        composable("details/{catIndex}", arguments = listOf(navArgument("catIndex"){type = NavType.IntType})){
            val catIndex = it.arguments?.getInt("catIndex") ?: 0
            DetailScreen(navController, petData = PetList[catIndex])
        }
    }
}

