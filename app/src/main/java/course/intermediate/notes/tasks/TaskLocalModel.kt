package course.intermediate.notes.tasks

import course.intermediate.notes.models.IContentModel
import course.intermediate.notes.models.ResultCallback
import course.intermediate.notes.models.Task
import course.intermediate.notes.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor(): IContentModel<Task>{

    override fun getFakeData(): MutableList<Task> = mutableListOf(
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

    override fun add(content: Task, callback: ResultCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(content: Task, callback: ResultCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(content: Task, callback: ResultCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieve(): List<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}