package kr.jeongmo.a0501project_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var datePicker: DatePicker
    lateinit var editDiary : EditText
    lateinit var btnWrite : Button
    lateinit var fileName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "간단 일기장"

        datePicker = findViewById(R.id.datePicker)

    }
}