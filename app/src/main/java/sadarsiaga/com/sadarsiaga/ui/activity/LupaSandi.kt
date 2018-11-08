package sadarsiaga.com.sadarsiaga.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lupa_sandi.*
import sadarsiaga.com.sadarsiaga.R

class LupaSandi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_sandi)

        bt_lanjut_1.setOnClickListener{
            val intent = (Intent(this@LupaSandi, LupaSandi_1::class.java))
            startActivity(intent)
        }
    }
}
