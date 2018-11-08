package sadarsiaga.com.sadarsiaga.helper

import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import sadarsiaga.com.sadarsiaga.R
import sadarsiaga.com.sadarsiaga.model.BencanaModel
import sadarsiaga.com.sadarsiaga.ui.DetailBencana

class RecyclerAdapter(val bencana : List<BencanaModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val titles = arrayOf("BMKG",
            "BMKG", "BMKG", "BMKG"
    )
    private val images = intArrayOf(R.drawable.image1,
            R.drawable.image2, R.drawable.image3,
            R.drawable.image4)
    private val newsSource: IntArray = intArrayOf(R.drawable.bmkg, R.drawable.bmkg,
            R.drawable.bmkg, R.drawable.bmkg)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(i,bencana[i])
    }

    override fun getItemCount(): Int {
        return bencana.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle: TextView =itemView.findViewById(R.id.item_title)
        var detailTime: TextView = itemView.findViewById(R.id.tv_news_time)
        var newsSource: ImageView = itemView.findViewById(R.id.news_source_image)


        fun bind(position: Int, bencanaModel: BencanaModel) {
            itemTitle.text = bencana[position].title
            detailTime.text = bencana[position].updatedAt
            Glide
                .with(itemView.context)
                .load(bencana[position].imgUrl)
                .into(itemImage)


            itemView.setOnClickListener {
                val intent = Intent(itemView.context,DetailBencana::class.java)
                intent.putExtra(DetailBencana.DETAIL_BENCANA_KEY,bencanaModel)
                itemView.context.startActivity(intent)
            }
        }

    }
}