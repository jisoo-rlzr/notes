package course.intermediate.notes.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import course.intermediate.notes.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NoteListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: NoteAdapter
    private lateinit var touchActionDelegate: NotesListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: NoteListViewContract

    fun init(touchDelegate: NotesListFragment.TouchActionDelegate, dataDelegate: NoteListViewContract) {
        setDelegate(touchDelegate, dataDelegate)
        setUp()
    }

    private fun setDelegate(touchDelegate: NotesListFragment.TouchActionDelegate, dataDelegate: NoteListViewContract) {
        touchActionDelegate = touchDelegate
        dataActionDelegate = dataDelegate
    }

    private fun setUp() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NoteAdapter(
            touchActionDelegate = touchActionDelegate,
            dataActionDelegate = dataActionDelegate
        )
        recyclerView.adapter = adapter
    }

    fun updateList(list: List<Note>) {
        adapter.updateList(list)
    }

}