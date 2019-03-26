package course.intermediate.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import course.intermediate.notes.R
import course.intermediate.notes.models.Task
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task

    fun initView(task: Task, todoCheckedCallback: (Int, Boolean) -> Unit) {
        this.task = task
        titleView.text = task.title

        task.todos.forEachIndexed { index, todo ->
            val todoView = LayoutInflater.from(context)
                .inflate(R.layout.view_todo, todoContainer, false)
                .apply {
                    todoView.initView(todo) { isChecked ->
                        todoCheckedCallback.invoke(index, isChecked)
                        setStrikeThrough(isTaskComplete())
                    }
                }
            todoContainer.addView(todoView)
        }
    }

    private fun isTaskComplete(): Boolean = task.todos.filter { !it.isComplete }.isEmpty()

    private fun setStrikeThrough(isChecked: Boolean) {
        titleView.apply {
            paintFlags =
                if (isChecked) {
                    paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                } else {
                    paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                }
        }
    }
}