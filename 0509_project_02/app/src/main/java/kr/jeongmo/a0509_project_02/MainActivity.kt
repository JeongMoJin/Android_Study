package kr.jeongmo.a0509_project_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButton()
    }

    private fun setButton() {
        val redButton = findViewById<Button>(R.id.buttonRedFragment)
        val blueButton = findViewById<Button>(R.id.buttonBluePragment)

        redButton.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentFrame, RedFragment())
            fragmentTransaction.commit()
        }

        blueButton.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentFrame, BlueFragment())
            fragmentTransaction.commit()
        }
    }
}















