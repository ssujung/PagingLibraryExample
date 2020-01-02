package com.ssujung.ex1.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ssujung.ex1.R
import com.ssujung.ex1.ui.dashboard.DashboardFragment
import com.ssujung.ex1.ui.home.HomeFragment

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val tabLayout: TabLayout = root.findViewById(R.id.tab_layout)
        val viewPager: ViewPager = root.findViewById(R.id.view_pager)

        // add tab
        tabLayout.addTab(tabLayout.newTab().setText("1"))
        tabLayout.addTab(tabLayout.newTab().setText("2"))
        tabLayout.addTab(tabLayout.newTab().setText("3"))

        viewPager.adapter = ViewPagerAdapter(fragmentManager!!, tabLayout.tabCount)
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {}
            override fun onTabUnselected(p0: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
        })
        return root
    }

    private inner class ViewPagerAdapter(
        fm: FragmentManager,
        private val tabCount: Int) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            return when (position) {
                0 -> HomeFragment()
                1 -> DashboardFragment()
                2 -> DashboardFragment()
                else -> null
            }
        }

        override fun getCount(): Int {
            return tabCount
        }
    }
}