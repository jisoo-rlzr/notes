package course.intermediate.notes.foundations

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T>(
    private val masterList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateList(list: List<T>) {
        val result = DiffUtil.calculateDiff(DiffUtilCallbackImpl(masterList, list))
        masterList.clear()
        masterList.addAll(list)
        result.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int): Int =
        if (position == 0) TYPE_ADD_BUTTON else TYPE_INFO

    override fun getItemCount(): Int = masterList.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AddButtonViewHolder) {
            holder.onBind(Unit, position - 1)
        } else {
            (holder as BaseViewHolder<T>).onBind(masterList[position - 1], position - 1)
        }
    }

    abstract class BaseViewHolder<E>(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: E, index: Int)
    }

    abstract class AddButtonViewHolder(view: View) : BaseViewHolder<Unit>(view)

    companion object {
        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1
    }

    class DiffUtilCallbackImpl<T>(private val old: List<T>, private val new: List<T>) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                = old[oldItemPosition] == new[newItemPosition]

        override fun getOldListSize(): Int = old.size

        override fun getNewListSize(): Int = new.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
                = old[oldItemPosition] == new[newItemPosition]

    }
}