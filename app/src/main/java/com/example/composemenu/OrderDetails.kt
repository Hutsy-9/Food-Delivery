package com.example.composemenu
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class OrderItem(
    val name: String,
    val price: String,
    val quantity: Int
)

@Composable
fun OrderSummaryScreen() {
    val orderItems = listOf(
        OrderItem("Jollof Rice", "Kshs 1,600", 2),
        OrderItem("Mixed Salad", "Kshs 1,200", 1),
        OrderItem("Spicy Noodles", "Kshs 1,500", 3)
    )
    val subtotal = "Kshs 6,300"
    val deliveryFee = "Kshs 700"
    val totalAmount = "Kshs 7,000"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Order Summary",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(orderItems.size) { index ->
                val item = orderItems[index]
                OrderItemCard(item)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Summary Section
        SummaryRow(label = "Subtotal", amount = subtotal)
        SummaryRow(label = "Delivery Fee", amount = deliveryFee)
        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
        SummaryRow(label = "Total Amount", amount = totalAmount)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Proceed to Payment */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Proceed to Payment", fontSize = 18.sp)
        }
    }
}

@Composable
fun OrderItemCard(item: OrderItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "${item.quantity} x ${item.price}", fontSize = 14.sp, color = Color.Gray)
        }
        Text(
            text = "N${item.quantity * item.price.drop(1).toInt()}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun SummaryRow(label: String, amount: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = 16.sp, color = Color.Gray)
        Text(text = amount, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun OrderSummaryPreview() {
    OrderSummaryScreen()
}


