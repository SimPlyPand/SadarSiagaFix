package sadarsiaga.com.sadarsiaga.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import sadarsiaga.com.sadarsiaga.R
import sadarsiaga.com.sadarsiaga.extension.active
import sadarsiaga.com.sadarsiaga.extension.attach
import sadarsiaga.com.sadarsiaga.extension.detach
import sadarsiaga.com.sadarsiaga.extension.disableShiftMode
import sadarsiaga.com.sadarsiaga.helper.BottomNavigationPosition
import sadarsiaga.com.sadarsiaga.helper.createFragment
import sadarsiaga.com.sadarsiaga.helper.findNavigationPositionById
import sadarsiaga.com.sadarsiaga.helper.getTag

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val KEY_POSITION = "keyPosition"

    private var navPosition: BottomNavigationPosition = BottomNavigationPosition.HOME

    private lateinit var toolbar: Toolbar

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restoreSaveInstanceState(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        setSupportActionBar(toolbar)
        initBottomNavigation()
        initFragment(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt(KEY_POSITION, navPosition.id)
        super.onSaveInstanceState(outState)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        navPosition = findNavigationPositionById(item.itemId)
        return switchFragment(navPosition)
    }

    private fun restoreSaveInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.also {
            val id = it.getInt(KEY_POSITION, BottomNavigationPosition.HOME.id)
            navPosition = findNavigationPositionById(id)
        }
    }

    private fun initBottomNavigation() {
        bottomNavigation.disableShiftMode()
        bottomNavigation.active(navPosition.position)
        bottomNavigation.setOnNavigationItemSelectedListener(this)
    }

    private fun initFragment(savedInstanceState: Bundle?) {
        savedInstanceState ?: switchFragment(BottomNavigationPosition.HOME)
    }

    private fun switchFragment(navPosition: BottomNavigationPosition): Boolean {
        return supportFragmentManager.findFragment(navPosition).let {
            if (it.isAdded) return false
            supportFragmentManager.detach()
            supportFragmentManager.attach(it, navPosition.getTag())
            supportFragmentManager.executePendingTransactions()
        }
    }

    private fun FragmentManager.findFragment(position: BottomNavigationPosition): Fragment {
        return findFragmentByTag(position.getTag()) ?: position.createFragment()
    }
}