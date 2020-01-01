package com.ssujung.ex1.base

/**
 * Copyright (c) 2019. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description :
 * @since 2019-12-31
 */
data class BaseItem<T>(
    val item: T,
    val viewType: Int
)