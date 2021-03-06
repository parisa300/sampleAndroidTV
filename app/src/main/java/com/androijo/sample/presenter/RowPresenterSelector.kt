package com.androijo.sample.presenter

import androidx.leanback.widget.FocusHighlight
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.PresenterSelector
import com.androijo.sample.fragments.CardListRow

class RowPresenterSelector : PresenterSelector() {
//when focus zoom change focusehighlight==ZOOM_FACTOR_LARGE
    val customListRowPresenter = object : ListRowPresenter(FocusHighlight.ZOOM_FACTOR_NONE, false) {
        override fun isUsingDefaultListSelectEffect() = false
        override fun isUsingDefaultShadow(): Boolean {
            return false
        }

    }.apply {
        shadowEnabled = false
    }


    private val mShadowEnabledRowPresenter = customListRowPresenter
    private val mShadowDisabledRowPresenter = customListRowPresenter

    init {
        mShadowEnabledRowPresenter.setNumRows(1)
        mShadowDisabledRowPresenter.shadowEnabled = true
    }

    override fun getPresenter(item: Any): Presenter {

        if (item !is CardListRow) return mShadowDisabledRowPresenter
        return mShadowDisabledRowPresenter
    }

    override fun getPresenters(): Array<Presenter> {
        return arrayOf(mShadowDisabledRowPresenter, mShadowEnabledRowPresenter)
    }

    fun getListRowPresenter(): ListRowPresenter = customListRowPresenter

}
