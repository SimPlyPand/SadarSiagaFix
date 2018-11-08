package sadarsiaga.com.sadarsiaga.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import sadarsiaga.com.sadarsiaga.R

class LoginActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}