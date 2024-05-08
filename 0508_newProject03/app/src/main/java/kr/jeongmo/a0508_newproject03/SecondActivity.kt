package kr.jeongmo.a0508_newproject03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnGoThird = findViewById<Button>(R.id.btnGoThird)
        btnGoThird.setOnClickListener {
            val intent = Intent(applicationContext, ThirdActivity::class.java)
            startActivity(intent)
        }

        val btnReturn1 = findViewById<Button>(R.id.btnReturn1)
        btnReturn1.setOnClickListener {
            finish()
        }
    }
}