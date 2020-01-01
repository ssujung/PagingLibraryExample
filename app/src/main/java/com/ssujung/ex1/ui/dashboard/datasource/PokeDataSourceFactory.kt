package com.ssujung.ex1.ui.dashboard.datasource

import androidx.paging.DataSource
import com.ssujung.ex1.ui.dashboard.api.PokemonService
import com.ssujung.ex1.ui.dashboard.data.RespResult

/**
 * Copyright (c) 2020. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description :
 * @since 2020-01-01
 */
class PokeDataSourceFactory(private val service: PokemonService) : DataSource.Factory<String, RespResult>() {
    override fun create(): DataSource<String, RespResult> {
        return PokeDataSource(service)
    }
}