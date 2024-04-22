package kr.jeongmo.only_kotlin_code_0422

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

    val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
    )

        // 내부용으로 사용할 파라미터
        val paramsSub = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            1.0f
        )

        // 기본 레이아웃 등록
        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        setContentView(baseLayout, params)

        // 바깥쪽 레이아웃 등록
        val firstOutLayout = LinearLayout(this)
        firstOutLayout.layoutParams = paramsSub
        firstOutLayout.orientation = LinearLayout.HORIZONTAL
        baseLayout.addView(firstOutLayout)

        val secondOutLayout = LinearLayout(this)
        secondOutLayout.layoutParams = paramsSub
        secondOutLayout.setBackgroundColor(Color.rgb(0,0,255))
        baseLayout.addView(secondOutLayout)

        // firstOutLayout에 빨간색 레이아웃과 자식 요소를 가질 레이아웃 등록
        val redLayout = LinearLayout(this)
        redLayout.layoutParams = paramsSub
        redLayout.setBackgroundColor(Color.rgb(255,0,0))
        firstOutLayout.addView(redLayout)

        val firstChildLayout = LinearLayout(this)
        firstChildLayout.layoutParams = paramsSub
        firstChildLayout.orientation = LinearLayout.VERTICAL
        firstOutLayout.addView(firstChildLayout)

        // firstChildLayout에 노란색과 검은색 레이아웃 추가
        val yellowLayout = LinearLayout(this)
        yellowLayout.layoutParams = paramsSub
        yellowLayout.setBackgroundColor(Color.rgb(255, 255, 0))
        firstChildLayout.addView(yellowLayout)

        val blackLayout = LinearLayout(this)
        blackLayout.layoutParams = paramsSub
        blackLayout.setBackgroundColor(Color.rgb(0,0,0))
        firstChildLayout.addView(blackLayout)
    }
}


























