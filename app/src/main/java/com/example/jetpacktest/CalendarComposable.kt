package com.example.jetpacktest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpacktest.ui.theme.JetpackTestTheme
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState

class CalendarComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HistoryScreen(SampleHabit.habitSample)
        }
    }
}

@Composable
fun HistoryScreen(habits: List<Habit>) {
    val calendarState = rememberSelectableCalendarState()
    Column {
        SelectableCalendar(calendarState = calendarState)
        Text("Hello")
        Text("${calendarState.selectionState.selection.joinToString { it.toString() }}")
        if (calendarState.selectionState.selection.size != 0) {
            Text("${calendarState.selectionState.selection[0].dayOfWeek.value}")
        }
        LazyColumn{
            items(habits) { habit ->
            HabitItem(habit = habit)
        }}
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackTestTheme {
        HistoryScreen(SampleHabit.habitSample)
    }
}