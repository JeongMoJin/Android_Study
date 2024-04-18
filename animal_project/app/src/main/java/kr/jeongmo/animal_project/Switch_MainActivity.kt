package kr.jeongmo.animal_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Switch_MainActivity : AppCompatActivity() {
    // 변수 선언
    lateinit var textView01 : TextView
    lateinit var switchAgree : Switch
    lateinit var textView02 : TextView
    lateinit var radioGroup02 : RadioGroup
    lateinit var androidOreo : RadioButton
    lateinit var androidPie : RadioButton
    lateinit var androidQ10 : RadioButton
    lateinit var imgAndroid : ImageView
    lateinit var btnEnd : Button
    lateinit var btnRe : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_main)

        title = "Android Favorite Version"

        // 변수 Id 할당
        textView01 = findViewById(R.id.textView01)
        switchAgree = findViewById(R.id.switchAgree)
        textView02 = findViewById(R.id.textView02)
        radioGroup02 = findViewById(R.id.radioGroup02)
        androidOreo = findViewById(R.id.androidOreo)
        androidPie = findViewById(R.id.androidPie)
        androidQ10 = findViewById(R.id.androidQ10)
        imgAndroid = findViewById(R.id.imgAndroid)
        btnEnd = findViewById(R.id.btnEnd)
        btnRe = findViewById(R.id.btnRe)

        // 스위치로 요소 출력 이벤트 등록
        switchAgree.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textView02.visibility = View.VISIBLE
                radioGroup02.visibility = View.VISIBLE
                imgAndroid.visibility = View.VISIBLE
                btnEnd.visibility = View.VISIBLE
                btnRe.visibility = View.VISIBLE
            } else{
                textView02.visibility = View.INVISIBLE
                radioGroup02.visibility = View.INVISIBLE
                imgAndroid.visibility = View.INVISIBLE
                btnEnd.visibility = View.INVISIBLE
                btnRe.visibility = View.INVISIBLE
            }
        }

        // 라디오 버튼 이벤트 등록 (클릭 시 해당 이미지 출력함)
        androidOreo.setOnClickListener {
            imgAndroid.setImageResource(R.drawable.oreo)
        }
        androidPie.setOnClickListener {
            imgAndroid.setImageResource(R.drawable.pie)
        }
        androidQ10.setOnClickListener {
            imgAndroid.setImageResource(R.drawable.q10)
        }

        btnEnd.setOnClickListener {
            finish()
        }

        btnRe.setOnClickListener {
            switchAgree.isChecked = false
            imgAndroid.setImageResource(0)
            radioGroup02.clearCheck()
        }
    }
}