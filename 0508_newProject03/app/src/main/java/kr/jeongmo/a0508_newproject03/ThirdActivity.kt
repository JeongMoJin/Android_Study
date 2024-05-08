package kr.jeongmo.a0508_newproject03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val btnReturn2 = findViewById<Button>(R.id.btnReturn2)
        btnReturn2.setOnClickListener {
            finish()
        }
    }
}


