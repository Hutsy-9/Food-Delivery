
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data class representing food items
data class FoodItem(val name: String, val price: String, val category: String)

// MenuScreen Composable Function
@Composable
fun MenuScreen() {
    val categories = listOf("Meals", "Sides", "Snacks")
    var selectedCategory by remember { mutableStateOf(0) }
    val foodItems = listOf(
        FoodItem("Spicy Noodles", "Kshs 1,500", "Meals"),
        FoodItem("Shrimp Pasta", "Kshs 1,800", "Meals"),
        FoodItem("Fries", "Kshs 1,800", "Sides"),
        FoodItem("Spring Rolls", "Kshs 700", "Snacks")
    )


    Scaffold(
        topBar = { TopAppBarWithCart() },
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            CategoryTabs(categories, selectedCategory) { index ->
                selectedCategory = index as Int as Int
            }
            // Filter food items based on selected category
            val filteredItems = foodItems.filter { it.category == categories[selectedCategory] }
            FoodGrid(filteredItems)
        }
    }
}

// TopAppBar with a cart icon
@Composable
fun TopAppBarWithCart() {
    TopAppBar(
        title = { Text(text = "Our Menu", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
        backgroundColor = Color(0xFFFF9800),
        actions = {
            IconButton(onClick = { /* Handle cart click */ }) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
            }
        }
    )
}


// Category Tabs for selecting different food categories
@Composable

fun CategoryTabs(categories: List<String>, selectedCategory: Int, param: (Any) -> Unit) {
    var selectedCategory by remember { mutableStateOf(value = 2) }

    TabRow(selectedTabIndex = selectedCategory, backgroundColor = Color.White) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = selectedCategory == index,
                onClick = {
                    selectedCategory = index

                },
                text = { Text(text = category, fontWeight = FontWeight.Bold) }
            )
        }
    }
}

// Grid for displaying food items
@Composable
fun FoodGrid(foodItems: List<FoodItem>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement  = Arrangement.spacedBy(8.dp)
    ) {
        items(foodItems) { foodItem ->
            FoodItemCard(foodItem)
        }
    }
}

// FoodItemCard to display food item details
@Composable
fun FoodItemCard(foodItem: FoodItem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* Handle item click */ }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for the image using a gradient background
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Gray, Color.LightGray)
                        ),
                        shape = RectangleShape
                    )
            )

            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = foodItem.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = foodItem.price, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}

// BottomNavigationBar with icons
@Composable
fun BottomNavigationBar() {
    BottomNavigation(backgroundColor = Color.White) {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { /* Handle Home click */ }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Dashboard, contentDescription = "Dashboard") },
            label = { Text("Dashboard") },
            selected = false,
            onClick = { /* Handle Dashboard click */ }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Notifications, contentDescription = "Notifications") },
            label = { Text("Notifications") },
            selected = false,
            onClick = { /* Handle Notifications click */ }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMenuScreen() {
    MenuScreen()
}





