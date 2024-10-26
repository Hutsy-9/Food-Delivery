package com.example.munchiesdelivery

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object Menu : BottomBarScreen(
        route = "menu",
        title = "Menu",
        icon = Icons.Default.Fastfood
    )
    object Favourites : BottomBarScreen(
        route = "favourites",
        title = "Favourites",
        icon = Icons.Default.Favorite
    )



}