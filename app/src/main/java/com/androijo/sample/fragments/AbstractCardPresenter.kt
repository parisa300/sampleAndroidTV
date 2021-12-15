package com.androijo.sample.fragments



import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.ViewGroup
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.RowHeaderView
import androidx.leanback.widget.RowPresenter
import com.androijo.sample.R

/**
 * This abstract, generic class will create and manage the
 * ViewHolder and will provide typed Presenter callbacks such that you do not have to perform casts
 * on your own.
 *
 * @param <T> View type for the card.
</T> */
abstract class AbstractCardPresenter<T : BaseCardView?>
/**
 * @param context The current context.
 */(val context: Context) :
    Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = onCreateView()
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        onBindViewHolder(item, viewHolder.view as T)
        val textView = viewHolder?.view?.findViewById<RowHeaderView>(R.id.row_header)
        textView?.run {
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12.5f)
            isAllCaps = true
            val typeFace = Typeface.createFromAsset(context?.assets, "iran_yekan_regular.ttf")
            typeface = typeFace
        }
    }
    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        onUnbindViewHolder(viewHolder.view as T)
    }

    fun onUnbindViewHolder(cardView: T) {
        // Nothing to clean up. Override if necessary.
    }

    /**
     * Invoked when a new view is created.
     *
     * @return Returns the newly created view.
     */
    protected abstract fun onCreateView(): T

    abstract fun onBindViewHolder(card: Any, cardView: T)

    companion object {
        private const val TAG = "AbstractCardPresenter"
    }


}