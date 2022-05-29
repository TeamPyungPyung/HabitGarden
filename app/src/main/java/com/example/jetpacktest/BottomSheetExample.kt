package com.example.jetpacktest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacktest.ui.theme.JetpackTestTheme
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.util.*

class BottomSheetExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetScaffoldSample(SampleHabit.habitSample)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScaffoldSample(habits: List<Habit>) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn {
                    items(habits) { habit ->
                        HabitItem(habit = habit)
                    }
                    items(1){
                        Spacer(Modifier.height(20.dp))
                    }
                    items(1) {
                        Button(
                            onClick = {
                                scope.launch { scaffoldState.bottomSheetState.collapse() }
                            }
                        ) {
                            Text("Click to collapse sheet")
                        }
                    }
                }
            }
        },
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Bottom sheet scaffold") },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                        Icon(Icons.Default.Menu, contentDescription = "Localized description")
                    }
                }
            )
        },
        floatingActionButton = {
            var clickCount by remember { mutableStateOf(0) }
            FloatingActionButton(
                onClick = {
                    // show snackbar as a suspend function
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Snackbar #${++clickCount}")
                    }
                }
            ) {
                Icon(Icons.Default.Favorite, contentDescription = "Localized description")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        sheetPeekHeight = 128.dp,
        drawerContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Drawer content")
                Spacer(Modifier.height(20.dp))
                Button(onClick = { scope.launch { scaffoldState.drawerState.close() } }) {
                    Text("Click to close drawer")
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(100) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    contentAlignment = Alignment.Center,

                ){
                    Text("test")
                }
            }
        }
    }
}



@Composable
fun HabitItem(habit: Habit) {
    MaterialTheme {
        var checked by remember { mutableStateOf(false)}
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .toggleable(
                    value = checked,
                    role = Role.Checkbox,
                    onValueChange = { checked = !checked }
                )
                .fillMaxWidth()
        ) {
            Text("${habit.habitName}", Modifier.weight(1f))
            Checkbox(checked = checked, onCheckedChange = null)
        }
    }
}

// today habit. todo : show only today's habit.
@Composable
fun HabitList(habits: List<Habit>) {
    LazyColumn {
        items(habits) { habit ->
            HabitItem(habit = habit)
        }
    }
}

@Preview
@Composable
fun HabitItemPreview() {
    JetpackTestTheme() {
        HabitItem(Habit(habitName = "test habit 1", days = arrayOf(true, true, true, true, true, true, true)))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackTestTheme {
        BottomSheetScaffoldSample(SampleHabit.habitSample)
    }
}