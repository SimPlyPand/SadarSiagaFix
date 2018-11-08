package sadarsiaga.com.sadarsiaga.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sadarsiaga.com.sadarsiaga.R

class BantuanFragment : Fragment() {

    companion object {
        val TAG: String = BantuanFragment::class.java.simpleName
        fun newInstance() = BantuanFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title = getString(R.string.title_bantuan)
        val view = inflater.inflate(R.layout.fragment_bantuan, container, false)
        return view
    }

}