package com.ssujung.ex1.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Copyright (c) 2019. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description :
 * @since 2019-12-31
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: T)
}