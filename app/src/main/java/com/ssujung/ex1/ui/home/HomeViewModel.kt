package com.ssujung.ex1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _numList = MutableLiveData<List<Int>>().apply {
        val list = mutableListOf<Int>()
        for (i in 1..100) {
            list.add(i)
        }
        value = list
    }
    val numList: LiveData<List<Int>> = _numList
}