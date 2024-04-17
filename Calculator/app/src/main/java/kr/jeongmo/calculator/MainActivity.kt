package kr.jeongmo.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var editText01: EditText
    lateinit var editText02: EditText
    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button
    lateinit var btnNam: Button
    lateinit var textViewResult: TextView
    lateinit var num1:String
    lateinit var num2:String
    var result: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Calculator"

        editText01 = findViewById(R.id.editText01)
        editText02 = findViewById(R.id.editText02)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)
        btnNam = findViewById(R.id.btnNam)
        textViewResult = findViewById(R.id.textViewResult)


        btnAdd.setOnClickListener {
            num1 = editText01.text.toString()
            num2 = editText02.text.toString()
            if (num1 == "" || num2 == "") {
                Toast.makeText(applicationContext, "값을 입력하셔야 됩니다.", Toast.LENGTH_SHORT).show()
            } else {
                result = (Integer.parseInt(num1)).toDouble() + (Integer.parseInt(num2)).toDouble()
                textViewResult.setText("계산 결과: ${result}")
            }
        }

        btnSub.setOnClickListener {
            num1 = editText01.text.toString()
            num2 = editText02.text.toString()
            if (num1 == "" || num2 == "") {
                Toast.makeText(applicationContext, "값을 입력하셔야 됩니다.", Toast.LENGTH_SHORT).show()
            } else {
                result = (Integer.parseInt(num1)).toDouble() - (Integer.parseInt(num2)).toDouble()
                textViewResult.setText("계산 결과: ${result}")
            }
        }

        btnMul.setOnClickListener {
            num1 = editText01.text.toString()
            num2 = editText02.text.toString()
            if (num1 == "" || num2 == "") {
                Toast.makeText(applicationContext, "값을 입력하셔야 됩니다.", Toast.LENGTH_SHORT).show()
            } else {
                result = (Integer.parseInt(num1)).toDouble() * (Integer.parseInt(num2)).toDouble()
                textViewResult.setText("계산 결과: ${result}")
            }
        }

        btnDiv.setOnClickListener {
            num1 = editText01.text.toString()
            num2 = editText02.text.toString()
            if (num1 == "" || num2 == "") {
                Toast.makeText(applicationContext, "값을 입력하셔야 됩니다.", Toast.LENGTH_SHORT).show()
            } else if(num1 == "0" || num2 == "0") {
                Toast.makeText(applicationContext, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
            } else {
                result = (Integer.parseInt(num1)).toDouble() / (Integer.parseInt(num2)).toDouble()
                textViewResult.setText("계산 결과: ${result}")
            }
        }

        btnNam.setOnClickListener {
            num1 = editText01.text.toString()
            num2 = editText02.text.toString()
            if (num1 == "" || num2 == "") {
                Toast.makeText(applicationContext, "값을 입력하셔야 됩니다.", Toast.LENGTH_SHORT).show()
            } else {
                result = (Integer.parseInt(num1)).toDouble() % (Integer.parseInt(num2)).toDouble()
                textViewResult.setText("계산 결과: ${result}")
            }
        }
    }
}