package com.ssujung.ex1.ui.dashboard.data

/**
 * Copyright (c) 2020. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description :
 * @since 2020-01-01
 */
data class Response(
    val count: Int,
    val previous: String,
    val next: String,
    val results: List<RespResult>
)
data class RespResult(
    val url: String,
    val name: String
)