package com.example.sumapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SumScreen()
        }
    }
}

@Composable
fun SumScreen() {
    var first by remember { mutableStateOf("") }
    var second by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Simple Sum App",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = first,
            onValueChange = { first = it },
            label = { Text("First Number") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = second,
            onValueChange = { second = it },
            label = { Text("Second Number") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            val a = first.toIntOrNull()
            val b = second.toIntOrNull()
            if (a != null && b != null) {
                result = a + b
            }
        }) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(24.dp))

        result?.let {
            Text(text = "The sum is: $it", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSumScreen() {
    SumScreen()
}
