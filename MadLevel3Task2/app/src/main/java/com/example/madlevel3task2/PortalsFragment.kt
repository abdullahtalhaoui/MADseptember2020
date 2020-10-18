package com.example.madlevel3task2

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager

import kotlinx.android.synthetic.main.fragment_portals.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PortalsFragment : Fragment() {
    val portals = arrayListOf<Portal>()
    val portalAdapter = PortalAdapter(portals, { portal: Portal -> onPortalClick(portal)})

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeAddPortalResult()

    }

    private fun initViews() {
        rvPortals.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        rvPortals.adapter = portalAdapter

    }

    private fun observeAddPortalResult() {
        setFragmentResultListener(REQ_PORTAL_KEY) { key, bundle ->
            bundle.getParcelable<Portal>(BUNDLE_PORTAL_KEY)?.let {
                portals.add(it)
                portalAdapter.notifyDataSetChanged()
            }?: Log.e("PortalFragment", "Request triggered, but empty portal text!")
        }

    }

    private fun onPortalClick(portal: Portal) {
        val builder = CustomTabsIntent.Builder()
        builder.addDefaultShareMenuItem()

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context, Uri.parse(portal.portalUrl))
    }
}
