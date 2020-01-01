package com.ssujung.ex1.ui.dashboard.datasource

import androidx.paging.DataSource
import com.ssujung.ex1.ui.dashboard.data.DashItem

/**
 * Copyright (c) 2020. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description : DataSource 생성하는 역
 * @since 2020-01-01
 */
class DashDataSourceFactory : DataSource.Factory<Int, DashItem>() {

    override fun create(): DataSource<Int, DashItem> {
        return DashDataSource()
    }
}