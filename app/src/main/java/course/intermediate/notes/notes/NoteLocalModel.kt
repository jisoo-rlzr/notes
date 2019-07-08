package course.intermediate.notes.notes

import course.intermediate.notes.models.Note
import course.intermediate.notes.models.ResultCallback
import javax.inject.Inject

class NoteLocalModel @Inject constructor(): INoteModel {

    override fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Test Note One"),
        Note("Test Note Two")
    )

    override fun add(content: Note, callback: ResultCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(content: Note, callback: ResultCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(content: Note, callback: ResultCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieve(): List<Note> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}