package com.example.jetpacktest

import java.util.*

data class Habit(
    val id: String = UUID.randomUUID().toString(),
    var habitName: String ="",
    var isAchieved: Boolean = false,
    var days: Array<Boolean> = arrayOf(false, false, false, false, false, false, false),
)

object SampleHabit {
    val habitSample = listOf(
        Habit(habitName = "drink water", days = arrayOf(false, false, true, true, false, false, true)) ,
        Habit(habitName = "go to gym", days = arrayOf(false, false, true, true, false, true, true)),
        Habit(habitName = "Study Android", days = arrayOf(true, false, true, false, false, false, true)),
        Habit(habitName = "go for a walk", days = arrayOf(false, true, true, true, false, false, true)),
        Habit(habitName = "cook for family", days = arrayOf(false, false, true, true, true, false, true)),

    )
}