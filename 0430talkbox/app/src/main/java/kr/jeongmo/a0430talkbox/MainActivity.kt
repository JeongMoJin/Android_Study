package kr.jeongmo.a0430talkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)

        button1.setOnClickListener {
            val versionArray = arrayOf("오레오", "파이", "큐(10)")
            val checkArray = booleanArrayOf(true, false, false)
            val dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("좋아하는 버전은?")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setMultiChoiceItems(versionArray, checkArray) {dialog, which, isChecked ->
                button1.text = versionArray[which]
            }
            dlg.setPositiveButton("닫기",null)
            dlg.show()
        }
    }
}




































