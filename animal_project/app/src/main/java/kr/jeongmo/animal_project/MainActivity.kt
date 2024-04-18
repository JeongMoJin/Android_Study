package kr.jeongmo.animal_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    // 변수 선언
    lateinit var textView01: TextView
    lateinit var checkBoxAgree : CheckBox
    lateinit var textView02: TextView
    lateinit var radioGroup: RadioGroup
    lateinit var radioButtonDog : RadioButton
    lateinit var radioButtonCat : RadioButton
    lateinit var radioButtonRabbit : RadioButton
    lateinit var btnOK : Button
    lateinit var imgPet : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Animal Gallery"
        
        // 변수 Id 할당
        textView01 = findViewById(R.id.textView01)
        checkBoxAgree = findViewById(R.id.checkBoxAgree)
        textView02 = findViewById(R.id.textView02)
        radioGroup = findViewById(R.id.radioGroup)
        radioButtonDog = findViewById(R.id.radioButtonDog)
        radioButtonCat = findViewById(R.id.radioButtonCat)
        radioButtonRabbit = findViewById(R.id.radioButtonRabbit)
        btnOK = findViewById(R.id.btnOK)
        imgPet = findViewById(R.id.imgPet)

        // 시작 체크 켜짐 안 켜짐 이벤트 등록
        checkBoxAgree.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textView02.visibility = View.VISIBLE
                radioGroup.visibility = View.VISIBLE
                btnOK.visibility = View.VISIBLE
                imgPet.visibility = View.VISIBLE
            } else {
                textView02.visibility = View.INVISIBLE
                radioGroup.visibility = View.INVISIBLE
                btnOK.visibility = View.INVISIBLE
                imgPet.visibility = View.INVISIBLE
            }
        }

        // '선택완료'를 클릭하면 동작하는 리스너를 정의
        btnOK.setOnClickListener {
            when (radioGroup.checkedRadioButtonId) {
                R.id.radioButtonDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.radioButtonCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.radioButtonRabbit -> imgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext,
                "동물을 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}