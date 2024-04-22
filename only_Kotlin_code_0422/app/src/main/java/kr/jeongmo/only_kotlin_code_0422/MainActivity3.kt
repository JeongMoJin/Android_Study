package kr.jeongmo.only_kotlin_code_0422

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        setContentView(baseLayout, params)

        val editText01 = EditText(this)
        editText01.hint = "여기에 입력하세요"
        baseLayout.addView(editText01)

        val btn = Button(this)
        btn.text = "버튼입니다"
        btn.setBackgroundColor(Color.YELLOW)
        baseLayout.addView(btn)

        val text01 = TextView(this)
        text01.text = "텍스트뷰입니다."
        text01.setTextColor(Color.MAGENTA)
        baseLayout.addView(text01)

        btn.setOnClickListener {
            text01.text= editText01.text
        }
    }
}