package kr.jeongmo.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn:Button = findViewById(R.id.button)
        btn.setOnClickListener {
            Toast.makeText(applicationContext, "!!", Toast.LENGTH_SHORT).show()
        }
    }
}