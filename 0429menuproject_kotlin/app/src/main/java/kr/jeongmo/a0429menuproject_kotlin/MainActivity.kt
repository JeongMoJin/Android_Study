package kr.jeongmo.a0429menuproject_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var baseLayout: LinearLayout
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "배경색 바꾸기"

        baseLayout = findViewById(R.id.baseLayout)
        button = findViewById(R.id.button1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)

        menu?.add(0,1,0,"배경색 (빨강)")
        menu?.add(0,2,0,"배경색 (초록)")
        menu?.add(0,3,0,"배경색 (파랑)")

        val subMenu = menu?.addSubMenu("버튼 변경 >> ")
        subMenu?.add(0, 4, 0, "버튼 45로 회전")
        subMenu?.add(0, 5, 0, "버튼 2배 확대")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                baseLayout.setBackgroundColor(Color.RED)
            }
            2 -> {
                baseLayout.setBackgroundColor(Color.GREEN)
            }
            3 -> {
                baseLayout.setBackgroundColor(Color.BLUE)
            }
            4 -> {
                button.rotation = 45f
            }
            5 -> {
                button.scaleX = 2f
            }
        }
        return super.onOptionsItemSelected(item)
    }
}