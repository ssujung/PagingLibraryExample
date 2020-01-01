package com.ssujung.ex1.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.ssujung.ex1.ui.dashboard.api.PokemonService
import com.ssujung.ex1.ui.dashboard.data.RespResult
import com.ssujung.ex1.ui.dashboard.datasource.PokeDataSourceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class PokeViewModel : ViewModel() {

    private val service: PokemonService = PokemonService.create()
    private val disposable = CompositeDisposable()

    private val dataSourceFactory = PokeDataSourceFactory(service)
    private val pagedListConfig = PagedList.Config.Builder()
        .setPageSize(20)
        .setInitialLoadSizeHint(20) // default: page size * 3
        .setPrefetchDistance(20) // default: page size
        .setEnablePlaceholders(true) // default: true
        .build()

    private val _pokeList: MutableLiveData<PagedList<RespResult>> = MutableLiveData()
    val pokeList: LiveData<PagedList<RespResult>>
        get() = _pokeList

    private val _showLoadingView: MutableLiveData<Boolean> = MutableLiveData()
    val showLoadingView: LiveData<Boolean>
        get() = _showLoadingView

    fun getPokeList() {
        _showLoadingView.postValue(true)
        RxPagedListBuilder(dataSourceFactory, pagedListConfig).buildObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                _showLoadingView.postValue(false)
            }.subscribe(
                {
                    _pokeList.postValue(it)
                },
                {
                    it.printStackTrace()
                }
            ).also { disposable.add(it) }
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}