package com.redbus.postalcodeapp.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController ,
        startDestination = "first_screen" ){

        composable("first_screen"){
            FirstScreen(){
                Log.d("MainActivity", "pincode: $it")
                if (it.isNotEmpty()) {
                    navController.navigate("list_screen/$it")
                }
            }
        }

        composable("list_screen/{pincode}"){

            val pincode = it.arguments?.getString("pincode")
            Log.d("MainActivity", "pincode in ListScreen: $pincode")
            PlaceListScreen(pincode ?: "560011")
        }
    }

}