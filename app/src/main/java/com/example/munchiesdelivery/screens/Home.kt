package com.example.munchiesdelivery.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.munchiesdelivery.HomeTopBar
import com.example.munchiesdelivery.R
import com.example.munchiesdelivery.SpecialOfferCardItem
import com.example.munchiesdelivery.model.homeItems
import com.example.munchiesdelivery.model.menuItems


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier){

    val scrollbehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            HomeTopBar(scrollBehavior = scrollbehaviour)
        }
    ) {paddingValues ->
        HomeScreenContent(
            modifier = Modifier.padding(paddingValues)
        )
    }
}
@Composable
fun HomeScreenContent(modifier: Modifier = Modifier){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,


    ) {
        Text(
            text = stringResource(id = R.string.home_intro),
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.home_subHeading),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
        )

        // search bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp), // padding around the row
            horizontalArrangement = Arrangement.Start, //
            verticalAlignment = Alignment.CenterVertically // vertically center the text
        ) {
            SearchBar(
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(onClick = { /*TODO*/

            }) {
                Icon(Icons.Default.FilterList, contentDescription = "Filter Icon")

            }
        }


        // Category Chips
        CategoryChips()

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Today`s Special Offer",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 20.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            items(homeItems.size) { index ->
                SpecialOfferCardItem(homeItems[index])
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp), // padding around the row
            horizontalArrangement = Arrangement.SpaceBetween, // align the items with space between
            verticalAlignment = Alignment.CenterVertically // vertically center the text
        ) {
            Text(
                text = "Popular Now",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
            )

            Text(text = "SEE FULL MENU",
                fontWeight = FontWeight.Normal,
                color = Color.Magenta,
                fontSize = 15.sp,
                modifier = Modifier
                    .clickable {

                    }
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(menuItems.size) { index ->
                MenuItemCard(menuItems[index])
            }
        }

    }




}


@Composable
fun SearchBar(modifier: Modifier) {
    OutlinedTextField(
        value = "",
        onValueChange = {
            /* Handle Search */
        },
        modifier = Modifier
            .padding(start = 10.dp),
        placeholder = { Text(text = "Enter a dish name e.g Misheveve") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        trailingIcon = { Icon(Icons.Default.Mic, contentDescription = "Voice Search") }

    )
}

@Composable
fun CategoryChips() {

    // List of categories
    val categories = listOf("Meals","Sides","Snacks","Drinks")

    // State list for chip selections
    val selectedChipStates = remember {
        categories.map { mutableStateOf(false) } }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
//        Chip(text = "Meals")
//        Chip(text = "Sides")
//        Chip(text = "Snacks")
//        Chip(text = "Drinks")

        // Render each chip with its corresponding state
        categories.forEachIndexed { index, category ->
            Chip(
                text = category,
                isSelected = selectedChipStates[index].value,
                onChipClicked = {
                    // Toggle the selection state of the clicked chip
                    selectedChipStates[index].value = !selectedChipStates[index].value
                }
            )
        }

    }
}

@Composable
fun Chip(text: String, isSelected: Boolean, onChipClicked: () -> Unit) {
    Button(
        onClick = onChipClicked,
        colors = ButtonDefaults.buttonColors(
//            containerColor = Color(0xFFFFC107),  // Background color
//            contentColor = Color.White,          // Text/icon color
//            disabledContainerColor = Color.Gray, // Background color when disabled
//            disabledContentColor = Color.LightGray // Text color when disabled
            containerColor = if (isSelected) Color(0xFFFFC107) else Color.LightGray, // Change color if selected
            contentColor = Color.White

        ),
    ) {
        Text(
            text,
            color = if (isSelected) Color.Black else Color.Gray, // Text color based on selection
            fontWeight = FontWeight.Bold
        )
    }
}
