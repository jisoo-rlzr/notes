package course.intermediate.notes.tasks

import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo
import javax.inject.Inject

class TaskModel @Inject constructor(){

    fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "Testing One", mutableListOf(
                Todo("todo 1", true),
                Todo("todo 2")
            )
        ),
        Task("Testing Two"),
        Task(
            "Testing Three", mutableListOf(
                Todo("test a"),
                Todo("test b")
            )
        )
    )

}