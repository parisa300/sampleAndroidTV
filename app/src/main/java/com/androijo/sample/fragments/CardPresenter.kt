package com.androijo.sample.fragments

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.leanback.widget.*
import com.androijo.sample.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.LoadedFrom
import com.squareup.picasso.Target

class CardPresenter(context: Context) :
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
        val textView1 = viewHolder?.view?.findViewById<RowHeaderView>(R.id.row_header)
        textView1?.run {
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12.5f)
            isAllCaps = true
            typeface = ResourcesCompat.getFont(textView1.context, R.font.iran_yekan_regular);
            textView1.text = data
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {

    }

}
