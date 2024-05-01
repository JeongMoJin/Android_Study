package kr.jeongmo.a0501project

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnWrite = findViewById<Button>(R.id.btnWrite)
        val btnRead = findViewById<Button>(R.id.btnRead)

        btnWrite.setOnClickListener {
            val outputStream = openFileOutput("file.txt", Context.MODE_PRIVATE)
            val string = "파일 처리 테스트"
            outputStream.write(string.toByteArray())
            outputStream.close()
            Toast.makeText(applicationContext, "file.txt가 생성됨.", Toast.LENGTH_SHORT).show()
        }

        btnRead.setOnClickListener {
            try {
                val inputStream = openFileInput("file.txt")
                val txt = ByteArray(30)
                inputStream.read(txt)
                val string = txt.toString(Charsets.UTF_8)
                Toast.makeText(applicationContext, "파일 없음", string, Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "파일 없음", Toast.LENGTH_SHORT).show()
            }
        }
    }

}