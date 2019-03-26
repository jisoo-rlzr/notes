package course.intermediate.notes.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.notes.models.Task
import kotlinx.android.synthetic.main.fragment_tasks_list.view.*

class TaskListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: TaskAdapter
    private lateinit var touchActionDelegate: TasksListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: TaskListViewContract

    fun init(touchDelegate: TasksListFragment.TouchActionDelegate, dataDelegate: TaskListViewContract) {
        setDelegate(touchDelegate, dataDelegate)
        setUp()
    }

    private fun setDelegate(touchDelegate: TasksListFragment.TouchActionDelegate, dataDelegate: TaskListViewContract) {
        touchActionDelegate = touchDelegate
        dataActionDelegate = dataDelegate
    }

    private fun setUp() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(
            touchActionDelegate = touchActionDelegate,
            dataActionDelegate = dataActionDelegate
        )
        recyclerView.adapter = adapter
    }

    fun updateList(list: List<Task>) {
        adapter.updateList(list)
    }

}