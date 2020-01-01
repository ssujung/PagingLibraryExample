package com.ssujung.ex1.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssujung.ex1.R

/**
 * Copyright (c) 2019. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description :
 * @since 2019-12-30
 */
class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {

    private val item: MutableList<Int> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_view_holder, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(item[position])
    }

    fun setNumList(list: List<Int>) {
        item.clear()
        item.addAll(list)
    }
}