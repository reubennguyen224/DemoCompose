package com.demoapp.democompose.ui.screens.home.state

data class User(
    val username: String = "",
    val completedTaskList: ListTask,
    val pendingTaskList: ListTask,
    val cancelTaskList: ListTask,
    val onGoingTaskList: ListTask
)
data class ListTask(
    val list: List<Task> = emptyList()
)
data class Task(
    val status: StatusTask = StatusTask.Completed,
    val title: String = "",
    val tags: Tags = Tags.Home,
    val type: TypeTask = TypeTask.Personal,
    val date: String = "",
    val timeBegin: String = "",
    val timeEnd: String = "",
    val description: String = ""
)
enum class TypeTask{
    Personal,
    Private,
    Secret
}
enum class StatusTask {
    Completed,
    Pending,
    Canceled,
    OnGoing
}

enum class Tags{
    Office,
    Home,
    Urgent,
    Work
}