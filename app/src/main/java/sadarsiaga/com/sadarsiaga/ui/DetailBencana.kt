package sadarsiaga.com.sadarsiaga.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_bencana.*
import sadarsiaga.com.sadarsiaga.R
import sadarsiaga.com.sadarsiaga.model.BencanaModel

class DetailBencana : AppCompatActivity() {
    companion object {
        val DETAIL_BENCANA_KEY = "detail bencana"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_bencana)
        val data = intent.getParcelableExtra<BencanaModel>(DETAIL_BENCANA_KEY)

        tv_title_detail?.text = data.title
        tv_tanggal_detail?.text =data.updatedAt
        tv_detail?.text= data.description

        Glide
            .with(this)
            .load(data.imgUrl)
            .into(iv_detail)


    }
}
