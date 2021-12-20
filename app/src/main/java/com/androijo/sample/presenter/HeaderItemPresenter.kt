package com.androijo.sample.presenter


import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.RowHeaderPresenter
import com.androijo.sample.R


class HeaderItemPresenter :RowHeaderPresenter() {

    private var mUnselectedAlpha = 0f

    override fun onCreateViewHolder(viewGroup: ViewGroup): ViewHolder? {
        val inflater = viewGroup.context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.item_header, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: Presenter.ViewHolder, o: Any) {
        val headerItem = (o as ListRow).headerItem
        val rootView: View = viewHolder.view
        val label = rootView.findViewById(R.id.header_label) as TextView
        label.run {
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12.5f)
            isAllCaps = true
            typeface = ResourcesCompat.getFont(label.context, R.font.iran_yekan_regular);
            label.text = headerItem.name
        }

    }

    override fun onUnbindViewHolder(viewHolder: Presenter.ViewHolder?) {
        // no op
    }


    override fun onSelectLevelChanged(holder: ViewHolder) {
        // this is a temporary fix
        holder.view.alpha = mUnselectedAlpha + holder.selectLevel *
                (1.0f - mUnselectedAlpha)
    }
}