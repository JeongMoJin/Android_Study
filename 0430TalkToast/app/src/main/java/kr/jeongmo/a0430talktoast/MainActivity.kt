package kr.jeongmo.a0430talktoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var button:Button
    lateinit var id : EditText
    lateinit var pass : EditText
    lateinit var dialogView : View
    private val memberId = "admin"
    private val memberPassword = "1234"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "로그인 정보 입력"

        button = findViewById(R.id.button)

        button.setOnClickListener {
            dialogView = View.inflate(this@MainActivity, R.layout.login1, null)

            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("로그인")
            dialog.setView(dialogView)
            dialog.setPositiveButton("확인") {dlog, which ->
                id = dialogView.findViewById(R.id.editText1)
                pass = dialogView.findViewById(R.id.editText2)

            }
            dialog.show()
        }
    }
    private fun procLogin(id:String, pass:String) {
        if ((id == memberId) && (pass == memberPassword)) {
            Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "로그인 실패", Toast.LENGTH_SHORT).show()
        }
    }
}


















