package com.inruca.smartbag

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.home_dashboard.*

class SmartBagDashboard : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_dashboard)
        addQuickAccessCircle()
        diconnect_bag.setOnClickListener {
            showdisconnectPopUpAndExit()
        }
    }

    private fun showdisconnectPopUpAndExit() {
        MaterialDialog(this).show {
            title(R.string.bag_disconnected)
            message(R.string.bag_has_been_disconnected)
            positiveButton(R.string.okay){
                dismiss()
                finish()
            }
            negativeButton(R.string.cancel){
                dismiss()
                finish()
            }
        }
    }

    private fun addQuickAccessCircle() {
        val contactCircle = ColorCircle(this)
        contactCircle.setColor(
            android.R.attr.colorBackground,
            resources.getColor(R.color.inrucaAccent)
        )
        contactCircle.id = R.id.oneCircle
        contactCircle.borderWidth = resources.getDimension(R.dimen.borderWidth)
        contactCircle.setImageResource(R.drawable.ic_toolbar_button)
        contactCircle.desc = getString(R.string.quick_access)
        contactCircle.circleRadius = resources.getDimension(R.dimen.side_menu_quick_access_radius)
        contactCircle.setOnClickListener(this)


        val servicesCircle = ColorCircle(this)
        servicesCircle.setColor(
            android.R.attr.colorBackground,
            resources.getColor(R.color.inrucaAccent)
        )
        servicesCircle.id = R.id.twoCircle
        servicesCircle.borderWidth = resources.getDimension(R.dimen.borderWidth)
        servicesCircle.setImageResource(R.drawable.ic_toolbar_button)
        servicesCircle.circleRadius = resources.getDimension(R.dimen.side_menu_quick_access_radius)
        servicesCircle.setOnClickListener(this)
        servicesCircle.desc = getString(R.string.quick_access)

        val nmmtStationCircle = ColorCircle(this)
        nmmtStationCircle.setColor(
            android.R.attr.colorBackground,
            resources.getColor(R.color.inrucaAccent)
        )
        nmmtStationCircle.id = R.id.threeCircle
        nmmtStationCircle.borderWidth = resources.getDimension(R.dimen.borderWidth)
        nmmtStationCircle.setImageResource(R.drawable.ic_toolbar_button)
        nmmtStationCircle.circleRadius =
            resources.getDimension(R.dimen.side_menu_quick_access_radius)
        nmmtStationCircle.setOnClickListener(this)
        nmmtStationCircle.desc = getString(R.string.quick_access)


        val nmmtabCircle = ColorCircle(this)
        nmmtabCircle.setColor(
            android.R.attr.colorBackground,
            resources.getColor(R.color.inrucaAccent)
        )
        nmmtabCircle.id = R.id.fourCircle
        nmmtabCircle.borderWidth = resources.getDimension(R.dimen.borderWidth)
        nmmtabCircle.setImageResource(R.drawable.ic_toolbar_button)
        nmmtabCircle.circleRadius = resources.getDimension(R.dimen.side_menu_quick_access_radius)
        nmmtabCircle.setOnClickListener(this)
        nmmtabCircle.desc = getString(R.string.quick_access)


        val msrtcCircle = ColorCircle(this)
        msrtcCircle.setColor(
            android.R.attr.colorBackground,
            resources.getColor(R.color.inrucaAccent)
        )
        msrtcCircle.id = R.id.fiveCircle
        msrtcCircle.borderWidth = resources.getDimension(R.dimen.borderWidth)
        msrtcCircle.setImageResource(R.drawable.ic_toolbar_button)
        msrtcCircle.circleRadius = resources.getDimension(R.dimen.side_menu_quick_access_radius)
        msrtcCircle.setOnClickListener(this)
        msrtcCircle.desc = getString(R.string.quick_access)

        val ferryCircle = ColorCircle(this)
        ferryCircle.setColor(
            android.R.attr.colorBackground,
            resources.getColor(R.color.inrucaAccent)
        )
        ferryCircle.id = R.id.sixCircle
        ferryCircle.borderWidth = resources.getDimension(R.dimen.borderWidth)
        ferryCircle.setImageResource(R.drawable.ic_toolbar_button)
        ferryCircle.circleRadius = resources.getDimension(R.dimen.side_menu_quick_access_radius)
        ferryCircle.setOnClickListener(this)
        ferryCircle.desc = getString(R.string.quick_access)


        val newsCircle = ColorCircle(this)
        newsCircle.setColor(android.R.attr.colorBackground, resources.getColor(R.color.inrucaAccent))
        newsCircle.id = R.id.sevenCircle
        newsCircle.borderWidth = resources.getDimension(R.dimen.borderWidth)
        newsCircle.setImageResource(R.drawable.ic_toolbar_button)
        newsCircle.circleRadius = resources.getDimension(R.dimen.side_menu_quick_access_radius)
        newsCircle.setOnClickListener(this)
        newsCircle.desc = getString(R.string.quick_access)

        val bookmarkCircle = ColorCircle(this)
        bookmarkCircle.setColor(
            android.R.attr.colorBackground,
            resources.getColor(R.color.inrucaAccent)
        )
        bookmarkCircle.id = R.id.eightCircle
        bookmarkCircle.borderWidth = resources.getDimension(R.dimen.borderWidth)
        bookmarkCircle.setImageResource(R.drawable.ic_toolbar_button)
        bookmarkCircle.circleRadius = resources.getDimension(R.dimen.side_menu_quick_access_radius)
        bookmarkCircle.setOnClickListener(this)
        bookmarkCircle.desc = getString(R.string.quick_access)


        val writeCircle = ColorCircle(this)
        writeCircle.setColor(
            android.R.attr.colorBackground,
            resources.getColor(R.color.inrucaAccent)
        )
        writeCircle.id = R.id.nineCircle
        writeCircle.borderWidth = resources.getDimension(R.dimen.borderWidth)
        writeCircle.setImageResource(R.drawable.ic_toolbar_button)
        writeCircle.circleRadius = resources.getDimension(R.dimen.side_menu_quick_access_radius)
        writeCircle.setOnClickListener(this)
        writeCircle.desc = getString(R.string.quick_access)


        

        
        val grid = findViewById<GridLayout>(R.id.quickAccess) as GridLayout
        grid.addView(contactCircle)
        grid.addView(servicesCircle)
        grid.addView(newsCircle)
        grid.addView(bookmarkCircle)
        grid.addView(nmmtStationCircle)
        grid.addView(nmmtabCircle)
        grid.addView(msrtcCircle)
        grid.addView(ferryCircle)
        grid.addView(writeCircle)
        


    }

    override fun onClick(v: View?) {

    }
}