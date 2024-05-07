package kr.jeongmo.a0507activityandintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.rg_btn1 -> intent = Intent(applicationContext, SecondActivity::class.java)
                R.id.rg_btn2 -> intent = Intent(applicationContext, ThirdActivity::class.java)
            }
        }

        val btnNewActivity = findViewById<Button>(R.id.newActivity)
        btnNewActivity.setOnClickListener {
            startActivity(intent)
        }
    }
}