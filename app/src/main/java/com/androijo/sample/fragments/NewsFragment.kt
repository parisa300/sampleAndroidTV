package com.androijo.sample.fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.*
import com.androijo.sample.R
import com.androijo.sample.interfaces.NavigationMenuCallback

class NewsFragment : BrowseSupportFragment() {

    private var mRowsAdapter: ArrayObjectAdapter = ArrayObjectAdapter(RowPresenterSelector())

    private lateinit var navigationMenuCallback: NavigationMenuCallback
    private val dataList = ArrayList<String>()

    init {
        initAdapters()
        initListeners()
    }

    private fun initAdapters() {
        adapter = mRowsAdapter
    }

    private fun initListeners() {
        onItemViewSelectedListener = OnItemViewSelectedListener {itemViewHolder, item, rowViewHolder, row ->
            val indexOfRow = mRowsAdapter.indexOf(row)

            val indexOfItem = ((row as CardListRow).adapter as ArrayObjectAdapter).indexOf(item)

            itemViewHolder?.view?.setOnKeyListener { v, keyCode, event ->
                if (event.action == KeyEvent.ACTION_DOWN) {
                    when (keyCode) {
                        KeyEvent.KEYCODE_DPAD_LEFT -> {
                            if (indexOfItem == 0) {
                                navigationMenuCallback.navMenuToggle(true)
                            }
                        }
                    }
                }
                false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.app_name)
        dataList.add("1")
        dataList.add("2")
        dataList.add("3")
        dataList.add("4")
        dataList.add("5")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createRows()
        setupUIElements()
    }
    private fun setupUIElements() {
        title = getString(R.string.browse_title)
        badgeDrawable = resources.getDrawable(R.drawable.ic_baseline_live_tv_24)
        headersState = BrowseSupportFragment.HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
        // set headers background color
        brandColor = ContextCompat.getColor(requireContext(), R.color.black)

    }
    private fun createRows() {
        for(rowIndex in 1..5){
            mRowsAdapter.add(createNewRow(rowIndex))
        }
    }

    private fun createNewRow(rowIndex: Int): Row {
        val presenterSelector = activity?.baseContext?.let {
            CardPresenterSelector(it)
        }
        val adapter = ArrayObjectAdapter(presenterSelector)
        for (data in dataList) {
            adapter.add(data)
        }
        val headerItem = HeaderItem(getString(R.string.News))
        return CardListRow(headerItem, adapter)
    }


    fun setNavigationMenuCallback(callback: NavigationMenuCallback) {
        this.navigationMenuCallback = callback
    }

    /**
     * this function can put focus or selected a specific item in a specific row
     */

    fun selectFirstItem() {
        setSelectedPosition(
            0,
            true,
            object : ListRowPresenter.SelectItemViewHolderTask(0) {
                override fun run(holder: Presenter.ViewHolder?) {
                    super.run(holder)
                    holder?.view?.postDelayed({
                        holder.view.requestFocus()
                    }, 10)
                }
            })
    }

}