package com.ssujung.ex1.ui.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ssujung.ex1.R

/**
 * Copyright (c) 2019. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description :
 * @since 2019-12-30
 */
class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val num: TextView by lazy { itemView.findViewById<TextView>(R.id.text) }

    fun onBind(item: Int) {
        num.text = item.toString()
    }
}