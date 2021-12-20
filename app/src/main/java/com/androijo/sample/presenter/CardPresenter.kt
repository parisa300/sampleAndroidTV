package com.androijo.sample.presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.leanback.widget.*
import com.androijo.sample.R

class CardPresenter(mContext: Context) :
   Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val cardView = BaseCardView(parent?.context, null, R.style.Widget_Leanback_BaseCardViewStyle)
        cardView.isFocusable = true
        cardView.addView(LayoutInflater.from(cardView.context).inflate(R.layout.card_subject, null, false))
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        val data = item as String
        val textView = viewHolder?.view?.findViewById<TextView>(R.id.cardName)
        val imageView = viewHolder?.view?.findViewById<ImageView>(R.id.movie_poster)
        textView?.text = data
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {

    }

}
