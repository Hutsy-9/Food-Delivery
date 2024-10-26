package com.example.munchiesdelivery.model

import com.example.munchiesdelivery.R

data class HomeItem(
    val image: Int,
    val name: String,
    val available: String,
    val price: String,
    val discount: String
)


val homeItems = listOf(
    HomeItem(R.drawable.crispy_chicken,name = "Crispy Chicken", available = "now", price = "KES 800","10% Off"),
    HomeItem(R.drawable.shawarma,name = "Shawarma", available = "now", price = "KES 350","10% Off"),
    HomeItem(R.drawable.family_combo,name = "Family Combo", available = "on-order", price = "KES 1500","10% Off"),
    HomeItem(R.drawable.burger_n_fries,name = "Burger And Fries", available = "now", price = "KES 850","10% Off"),
    HomeItem(R.drawable.three_patty_burger,name = "Three Patty Burger", available = "now", price = "KES 950","10% Off"),
)