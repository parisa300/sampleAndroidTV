package com.androijo.sample.presenter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.leanback.widget.*
import com.androijo.sample.R

class CardPresenter(mContext: Context) :
   Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val cardView =
            BaseCardView(parent?.context, null, R.style.Widget_Leanback_BaseCardViewStyle)
        val highElevation = parent?.resources?.getDimension(R.dimen.dimens_10sp)
        val standardElevation = parent?.resources?.getDimension(R.dimen.dimens_22dp)
        val standardBackground = ContextCompat.getColor(cardView.context, R.color.black)
        val focusedBackground = ContextCompat.getColor(cardView.context, R.color.white)
        cardView.isFocusable = true
        cardView.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            cardView.apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    outlineSpotShadowColor = if (hasFocus) focusedBackground else standardBackground
                }
                elevation = if (hasFocus) highElevation!! else standardElevation!!
            }


        }
        cardView.addView(
            LayoutInflater.from(cardView.context).inflate(R.layout.card_subject, null, false)
        )
        return ViewHolder(cardView)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        val data = item as String
        val textView = viewHolder?.view?.findViewById<TextView>(R.id.cardName)
        val imageView = viewHolder?.view?.findViewById<ImageView>(R.id.movie_poster)
        val cl_backs :ConstraintLayout? = viewHolder?.view?.findViewById(R.id.cl_back)
        textView?.text = data
   /*     cl_backs?.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                cl_backs.setBackgroundColor(Color.BLUE)
            } else{
                cl_backs.setBackgroundColor(Color.RED);
            }
        }*/

    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {

    }

}
