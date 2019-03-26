package course.intermediate.notes.views

import android.graphics.Paint
import android.widget.TextView

fun TextView.setStrikeThrough(set: Boolean) {
    paintFlags =
        if (set)
            paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        else
            paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
}