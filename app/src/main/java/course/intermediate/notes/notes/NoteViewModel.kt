package course.intermediate.notes.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import course.intermediate.notes.models.IContentModel
import course.intermediate.notes.models.Note
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class NoteViewModel : ViewModel(), NoteListViewContract {

    @Inject
    lateinit var localModel: IContentModel<Note>

    private val _noteListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val noteListLiveData: LiveData<MutableList<Note>> = _noteListLiveData

    init {
        val scope = Toothpick.openScope(this)
        scope.installModules(object :Module() {
            init {
                bind(IContentModel::class.java).toInstance(NoteLocalModel())
            }
        })
        Toothpick.inject(this, scope)

        _noteListLiveData.postValue(localModel.getFakeData())
    }

}