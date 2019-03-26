package course.intermediate.notes.notes

import course.intermediate.notes.models.Note

class NoteModel {

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Test Note One"),
        Note("Test Note Two")
    )

}