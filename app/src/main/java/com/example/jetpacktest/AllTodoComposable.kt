package com.example.jetpacktest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacktest.ui.theme.JetpackTestTheme

class AllTodoComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun AllHabits(habits: List<Habit>) {
    LazyColumn {
        items(habits) { habit ->
            HabitItemDetail(habit = habit)
        }
    }
}

@Composable
fun HabitItemDetail(habit: Habit) {
    MaterialTheme {
        Card(
            modifier = Modifier.padding(all = 4.dp),
            border = BorderStroke(1.dp, Color.Black)
            ) {
            Column() {
                Row(
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text("${habit.habitName}", Modifier.weight(1f))
                }
                Row(
                    modifier = Modifier
                        .padding(all = 4.dp)
                ) {
                    Box() {
                        Text(text = "Mon")
                    }
                    Box() {
                        Text(text = "Mon")
                    }
                    Box() {
                        Text(text = "Mon")
                    }
                    Box() {
                        Text(text = "Mon")
                    }
                    Box() {
                        Text(text = "Mon")
                    }
                    Box() {
                        Text(text = "Mon")
                    }
                    Box() {
                        Text(text = "Mon")
                    }
                    Box() {
                        Text(text = "Mon")
                    }
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    JetpackTestTheme {
        AllHabits(habits = SampleHabit.habitSample)
    }
}