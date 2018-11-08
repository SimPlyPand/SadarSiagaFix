package sadarsiaga.com.sadarsiaga

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_menu_berita.view.*

class RecyclerAdapaterMenuBerita : RecyclerView.Adapter<RecyclerAdapaterMenuBerita.Holder>() {

    val menu = arrayListOf("Semua","Gempa","Gunung Api","Banjir","Longsor")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu_berita,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

      holder.itemView.txt_menu.text = menu[position]
    }


    inner class Holder(view : View) : RecyclerView.ViewHolder(view)
}