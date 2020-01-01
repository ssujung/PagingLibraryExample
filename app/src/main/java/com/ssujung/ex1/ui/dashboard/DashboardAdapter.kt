package com.ssujung.ex1.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.ssujung.ex1.R
import com.ssujung.ex1.ui.dashboard.data.RespResult

/**
 * Copyright (c) 2019. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description :
 * @since 2019-12-31
 */
class DashboardAdapter : PagedListAdapter<RespResult, PokeViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dash_view_holder, parent, false)
        return PokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.onBind(it)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RespResult>() {
            override fun areItemsTheSame(oldItem: RespResult, newItem: RespResult): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: RespResult, newItem: RespResult): Boolean {
                return oldItem == newItem
            }
        }
    }
}