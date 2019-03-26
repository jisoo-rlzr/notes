package course.intermediate.notes.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import course.intermediate.notes.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 11
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var onCheckCallback: ((Boolean) -> Unit)? = null

    fun initView(todo: Todo, callback: ((Boolean) -> Unit)? = null) {
        descriptionView.text = todo.description

        completeCheckbox.isChecked = todo.isComplete
        if (todo.isComplete) {
            setStrikeThrough(true)
        }

        onCheckCallback = callback
        completeCheckbox.setOnCheckedChangeListener { _, isChecked ->
            todo.isComplete = isChecked
            setStrikeThrough(isChecked)
            onCheckCallback?.invoke(isChecked)
        }
    }

    private fun setStrikeThrough(isChecked: Boolean) {
        descriptionView.apply {
            paintFlags =
                if (isChecked) {
                    paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                } else {
                    paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                }
        }
    }

}
