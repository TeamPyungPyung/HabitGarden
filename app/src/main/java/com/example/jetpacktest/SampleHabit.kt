package com.example.jetpacktest

import java.util.*

data class Habit(
    val id: String = UUID.randomUUID().toString(),
    val habitName: String ="",
    var isAchieved: Boolean = false,
    var days: Days,
)

class Days(
    var Mon: Boolean = false,
    var Tue: Boolean = false,
    var Wed: Boolean = false,
    var Thu: Boolean = false,
    var Fri: Boolean = false,
    var Sat: Boolean = false,
    var Sun: Boolean = false,

)

object SampleHabit {
    val habitSample = listOf(
        Habit(habitName = "drink water", days = Days(Mon = true, Wed = true, Fri = true) ),
        Habit(habitName = "go to gym", days = Days(Tue = true)),
        Habit(habitName = "Study Android", days = Days(Thu = true)),
        Habit(habitName = "go for a walk", days = Days(Sat = true)),
        Habit(habitName = "cook for family", days = Days(Sun = true)),

    )
}