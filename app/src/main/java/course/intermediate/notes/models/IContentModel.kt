package course.intermediate.notes.models

typealias ResultCallback = (Boolean) -> Unit

interface IContentModel<T> {

    fun add(content: T, callback: ResultCallback)
    fun update(content: T, callback: ResultCallback)
    fun delete(content: T, callback: ResultCallback)
    fun retrieve(): List<T>

    fun getFakeData(): MutableList<T>

}