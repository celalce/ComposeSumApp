# 📱 Simple Sum App (Kotlin + Jetpack Compose)

A clean and minimal Android app built with **Kotlin** and **Jetpack Compose**, designed to perform a simple addition of two numbers entered by the user.  
This project demonstrates how to handle text input, state management, and button actions in Compose UI.

---



---

## 🚀 Features
- 🧮 Input two numbers  
- ➕ Calculate their sum  
- 💬 Display the result instantly  
- 🎨 Built with **Jetpack Compose** (modern Android UI toolkit)

---

## 🧠 Code Example

```kotlin
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
        Text("Simple Sum App", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = first,
            onValueChange = { first = it },
            label = { Text("First Number") }
        )

        OutlinedTextField(
            value = second,
            onValueChange = { second = it },
            label = { Text("Second Number") }
        )

        Button(onClick = {
            val a = first.toIntOrNull()
            val b = second.toIntOrNull()
            if (a != null && b != null) result = a + b
        }) {
            Text("Calculate")
        }

        result?.let {
            Text("The sum is: $it", fontSize = 20.sp)
        }
    }
}
