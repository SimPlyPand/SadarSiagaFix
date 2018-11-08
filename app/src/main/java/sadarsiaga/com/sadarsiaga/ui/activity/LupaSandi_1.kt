package sadarsiaga.com.sadarsiaga.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lupa_sandi_1.*
import sadarsiaga.com.sadarsiaga.R

class LupaSandi_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lupa_sandi_1)

        bt_lanjut_2.setOnClickListener{
            val intent = (Intent(this@LupaSandi_1, KataSandiBaru::class.java))
            startActivity(intent)
        }
    }
}
