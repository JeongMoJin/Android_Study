package kr.jeongmo.a0430talkproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var textViewName : TextView
    lateinit var textViewEmail : TextView
    lateinit var button : Button
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var toastText1: TextView
    lateinit var dialogView: View
    lateinit var toastView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "사용자 정보 입력"

        textViewName = findViewById(R.id.textViewName)
        textViewEmail = findViewById(R.id.textViewEmail)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.dialog1, null)

            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("사용자 정보 입력")
            dialog.setIcon(R.drawable.ic_menu_allfriends)
            dialog.setView(dialogView)
            dialog.setPositiveButton("확인") {dlog, which ->
                editText1 = dialogView.findViewById(R.id.editText1)
                editText2 = dialogView.findViewById(R.id.editText2)

                textViewName.text = editText1.text.toString()
                textViewEmail.text = editText2.text.toString()
            }
            dialog.setNegativeButton("취소") {dlog, which ->
                val toast = Toast(this@MainActivity)
                toastView = View.inflate(this@MainActivity, R.layout.toast1, null)
                toastText1 = toastView.findViewById<TextView>(R.id.toastText1)
                toastText1.text = "취소했습니다"
                toast.view = toastView
                toast.show()
            }
            dialog.show()
        }

    }
}














