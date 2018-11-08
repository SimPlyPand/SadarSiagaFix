package sadarsiaga.com.sadarsiaga.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_berita.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sadarsiaga.com.sadarsiaga.BaseApp
import sadarsiaga.com.sadarsiaga.R
import sadarsiaga.com.sadarsiaga.RecyclerAdapaterMenuBerita
import sadarsiaga.com.sadarsiaga.helper.RecyclerAdapter
import sadarsiaga.com.sadarsiaga.model.BencanaResponse


class BeritaFragment : Fragment() {

    companion object {
        val TAG: String = BeritaFragment::class.java.simpleName
        fun newInstance(): BeritaFragment {
            var beritaFragment = BeritaFragment()
            var args = Bundle()
            beritaFragment.arguments = args
            return beritaFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title = getString(R.string.title_berita)
        val view = inflater.inflate(R.layout.fragment_berita, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view.layoutManager = LinearLayoutManager(context)

        recycler_view_horizontal.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler_view_horizontal.adapter = RecyclerAdapaterMenuBerita()


        BaseApp.service.bencanaList().enqueue(object : Callback<BencanaResponse> {
            override fun onFailure(call: Call<BencanaResponse?>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<BencanaResponse?>?, response: Response<BencanaResponse>) {
                Log.d("Berita Fragment", "data : ${Gson().toJsonTree(response.body())}")
                recycler_view.adapter = RecyclerAdapter(response.body()?.result!!)

            }

        })

    }
}





