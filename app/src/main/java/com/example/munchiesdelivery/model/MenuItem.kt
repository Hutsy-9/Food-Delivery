package com.example.munchiesdelivery.model

import com.example.munchiesdelivery.R

data class MenuItem(
    val name:String,
    val price: String,
    val imageResId: Int // store the drawable resource id
)

val menuItems = listOf(
    MenuItem("Spicy Noodles", "Kes 500", R.drawable.spicy_noodles),
    MenuItem("Shrimp Pasta", "Kes 800", R.drawable.shrimp_pasta),
    MenuItem("Vegetable Curry", "Kes 200", R.drawable.vegetable_curry),
    MenuItem("Mixed Salad", "Kes 500", R.drawable.mixed_salad),
    MenuItem("Chicken Pasta Salad", "Kes 500", R.drawable.chicken_pasta_salad),
)