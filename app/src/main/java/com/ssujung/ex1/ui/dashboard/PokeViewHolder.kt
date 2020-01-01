package com.ssujung.ex1.ui.dashboard

import android.view.View
import android.widget.TextView
import com.ssujung.ex1.R
import com.ssujung.ex1.base.BaseViewHolder
import com.ssujung.ex1.ui.dashboard.data.RespResult

/**
 * Copyright (c) 2019. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description :
 * @since 2019-12-31
 */
class PokeViewHolder(itemView: View) : BaseViewHolder<RespResult>(itemView) {

    private val id: TextView by lazy { itemView.findViewById<TextView>(R.id.num) }
    private val desc: TextView by lazy { itemView.findViewById<TextView>(R.id.desc) }

    override fun onBind(item: RespResult) {
        id.text = item.name
        desc.text = item.url
    }
}