package com.demoapp.democompose.ui.screens.task

import com.demoapp.democompose.ui.screens.home.state.ListTask

data class Day(
    val dayNumber: String = "14",
    val day: String = "MO",
    val isSelected: Boolean = false
)
data class DayList(
    val list: List<Day> = listOf(
        Day(day = "MO", dayNumber = "14"),
        Day(day = "TU", dayNumber = "15"),
        Day(day = "WE", dayNumber = "16"),
        Day(day = "TH", dayNumber = "17"),
        Day(day = "FR", dayNumber = "18"),
        Day(day = "SA", dayNumber = "19"),
        Day(day = "SU", dayNumber = "20"),
    )
)
data class TaskList(
    val time: String = "9:00",
    val listTask: ListTask = ListTask()
)