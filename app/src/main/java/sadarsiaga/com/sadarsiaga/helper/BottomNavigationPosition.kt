package sadarsiaga.com.sadarsiaga.helper

import android.support.v4.app.Fragment
import sadarsiaga.com.sadarsiaga.R
import sadarsiaga.com.sadarsiaga.ui.fragments.BantuanFragment
import sadarsiaga.com.sadarsiaga.ui.fragments.BeritaFragment
import sadarsiaga.com.sadarsiaga.ui.fragments.HomeFragment
import sadarsiaga.com.sadarsiaga.ui.fragments.ProfileFragment

enum class BottomNavigationPosition(val position: Int, val id: Int) {
    HOME(0, R.id.home),
    BANTUAN(1, R.id.bantuan),
    BERITA(2, R.id.berita),
    PROFILE(3, R.id.profile);
}

fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.HOME.id -> BottomNavigationPosition.HOME
    BottomNavigationPosition.BANTUAN.id -> BottomNavigationPosition.BANTUAN
    BottomNavigationPosition.BERITA.id -> BottomNavigationPosition.BERITA
    BottomNavigationPosition.PROFILE.id -> BottomNavigationPosition.PROFILE
    else -> BottomNavigationPosition.HOME
}

fun BottomNavigationPosition.createFragment(): Fragment = when (this) {
    BottomNavigationPosition.HOME -> HomeFragment.newInstance()
    BottomNavigationPosition.BANTUAN -> BantuanFragment.newInstance()
    BottomNavigationPosition.BERITA -> BeritaFragment.newInstance()
    BottomNavigationPosition.PROFILE -> ProfileFragment.newInstance()
}

fun BottomNavigationPosition.getTag(): String = when (this) {
    BottomNavigationPosition.HOME -> HomeFragment.TAG
    BottomNavigationPosition.BANTUAN -> BantuanFragment.TAG
    BottomNavigationPosition.BERITA -> BeritaFragment.TAG
    BottomNavigationPosition.PROFILE -> ProfileFragment.TAG
}

