package com.ssujung.ex1.ui.dashboard.datasource

import android.util.Log
import androidx.paging.PositionalDataSource
import com.ssujung.ex1.ui.dashboard.data.DashItem

/**
 * Copyright (c) 2019. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description : 로컬 또는 Backend의 데이터를 가져오는 역할
 *  PositionalDataSource: 위치기반의 데이터를 로딩하는 DataSource입니다. 셀 수 있는 데이터, 고정된 사이즈의 데이터를 로딩할 때 사용됩니다.
 *  만약 끝을 알 수 없는 무한대의 아이템이라면, ItemKeyedDataSource 또는 PageKeyedDataSource이 적합합니다.
 *  Room은 PositionalDataSource 타입의 소스를 제공합니다.
 *
 * ItemKeyedDataSource: 키 기반의 아이템을 로딩하는 DataSource입니다.
 * PageKeyedDataSource: 페이지 기반의 아이템을 로딩하는 DataSource입니다.
 *
 * @since 2019-12-31
 */
class DashDataSource : PositionalDataSource<DashItem>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<DashItem>) {
        Log.d("sujung", "[requestStartPosition] ${params.requestedStartPosition}  [requestedLoadSize] ${params.requestedLoadSize}")
        callback.onResult(getItems(params.requestedStartPosition, params.requestedLoadSize), 0, 100)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<DashItem>) {
        Log.d("sujung", "[startPosition] ${params.startPosition}  [loadSize] ${params.loadSize}")
        callback.onResult(getItems(params.startPosition, params.loadSize))
    }

    private fun getItems(startPosition: Int, loadSize: Int): List<DashItem> {
        val list = ArrayList<DashItem>()
        for (i in 0 until loadSize) {
            val itemPos = startPosition + i
            list.add(DashItem(itemPos, "가나다"))
        }
        return list
    }
}