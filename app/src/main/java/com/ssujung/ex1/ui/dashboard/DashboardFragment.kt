package com.ssujung.ex1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssujung.ex1.R

class DashboardFragment : Fragment() {

    private lateinit var pokeViewModel: PokeViewModel
    private val adapter = DashboardAdapter()

    private var recyclerView: RecyclerView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pokeViewModel = ViewModelProviders.of(this).get(PokeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerView = root.findViewById(R.id.recycler_view)
        progressBar = root.findViewById(R.id.progress)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        requestData()

//        pokeViewModel.showLoadingView.observe(this, Observer {
//            progressBar?.visibility = if (it) View.VISIBLE else View.INVISIBLE
//        })
        pokeViewModel.pokeList.observe(this, Observer {
            hideLoadingView()
            adapter.submitList(it)
        })
    }

    private fun requestData() {
        showLoadingView()
        pokeViewModel.getPokeList()
    }

    private fun initRecyclerView() {
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
    }

    private fun showLoadingView() {
        progressBar?.visibility = View.VISIBLE
    }

    private fun hideLoadingView() {
        progressBar?.visibility = View.GONE
    }
}