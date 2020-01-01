package com.ssujung.ex1.ui.dashboard.datasource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.ssujung.ex1.ui.dashboard.api.PokemonService
import com.ssujung.ex1.ui.dashboard.data.RespResult
import com.ssujung.ex1.ui.dashboard.data.Response
import retrofit2.Call
import retrofit2.Callback

/**
 * Copyright (c) 2020. TMON Inc. All rights reserved.
 *
 * @author sujung26
 * @see Description :
 * @since 2020-01-01
 */
class PokeDataSource(private val service: PokemonService) : PageKeyedDataSource<String, RespResult>() {

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, RespResult>) {
        Log.d("sujung", "[loadInitial] requestedLoadSize: ${params.requestedLoadSize}")
//        val body = service.listPokemons().execute().body()
//        callback.onResult(body!!.results, null, body.next)
        service.listPokemons().enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val body = response.body()
                callback.onResult(body!!.results, null, body.next)
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                call.cancel()
            }
        })
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, RespResult>) {
        Log.d("sujung", "[loadBefore] key: ${params.key}")
        val map = handleKey(params.key)
//        val body = service.listPokemons(map["offset"]!!, map["limit"]!!).execute().body()
//        callback.onResult(body!!.results, body.previous)
        service.listPokemons(map["offset"]!!, map["limit"]!!).enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val body = response.body()
                callback.onResult(body!!.results, body.previous)
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                call.cancel()
            }
        })
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, RespResult>) {
        Log.d("sujung", "[loadAfter] key: ${params.key}")
        val map = handleKey(params.key)
//        val body = service.listPokemons(map["offset"]!!, map["limit"]!!).execute().body()
//        callback.onResult(body!!.results, body.next)
        service.listPokemons(map["offset"]!!, map["limit"]!!).enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val body = response.body()
                callback.onResult(body!!.results, body.next)
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                call.cancel()
            }
        })
    }

    private fun handleKey(key: String): MutableMap<String, String> {
        val (_, queryPart) = key.split("?")
        val queries = queryPart.split("&".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val map = mutableMapOf<String, String>()
        for (query in queries) {
            val (k, v) = query.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            map[k] = v
        }
        return map
    }
}