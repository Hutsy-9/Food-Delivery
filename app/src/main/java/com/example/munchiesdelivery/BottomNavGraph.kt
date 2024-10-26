package com.example.munchiesdelivery

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.munchiesdelivery.screens.FavouritesScreen
import com.example.munchiesdelivery.screens.HomeScreen
import com.example.munchiesdelivery.screens.MenuScreen
import com.example.munchiesdelivery.screens.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Menu.route){
            MenuScreen()
        }
        composable(route = BottomBarScreen.Favourites.route){
            FavouritesScreen()
        }

    }
}