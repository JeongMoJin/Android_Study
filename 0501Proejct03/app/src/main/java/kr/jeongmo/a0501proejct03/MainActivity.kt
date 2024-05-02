package kr.jeongmo.a0501proejct03

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log.println
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a03_directory_list)

        /*
         1. SD카드 파일 읽기

        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Context.MODE_PRIVATE
        )


        val btnRead = findViewById<Button>(R.id.btnRead)
        val editSD = findViewById<EditText>(R.id.editSD)

        btnRead.setOnClickListener {
            try {
                val inputStream = FileInputStream("/storage/emulated/0/Download/text.txt")
                val txt = ByteArray(inputStream.available())
                inputStream.read(txt)
                editSD.setText(txt.toString(Charsets.UTF_8))
                inputStream.close()
            } catch (e : IOException) {
                Toast.makeText(applicationContext, "에러", Toast.LENGTH_SHORT).show()
            }
        }
          */

        // 2. SD카드 파일 생성, 삭제
        /*
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Context.MODE_PRIVATE
        )

        val btnMkdir = findViewById<Button>(R.id.btnMkDir)
        val btnRmdir = findViewById<Button>(R.id.btnRmDir)

        val strSDpath = Environment.getExternalStorageDirectory().absolutePath
        val myDir = File("${strSDpath}/MyDir")

        btnMkdir.setOnClickListener {
            myDir.mkdir()
        }

        btnRmdir.setOnClickListener {
            myDir.delete()
        }
         */

        // 3. SD카드 폴더, 파일 목록
        val btnFileList = findViewById<Button>(R.id.btnFileList)
        val editFileList = findViewById<EditText>(R.id.editFileList)
        btnFileList.setOnClickListener {
            val sysDir = Environment.getRootDirectory().absolutePath
            val sysFiles = File(sysDir).listFiles()

            var strFname : String
            for (i in sysFiles.indices) {
                if (sysFiles[i].isDirectory == true)
                    strFname = "<폴더> " + sysFiles[i].toString()
                else
                    strFname = "<파일> " + sysFiles[i].toString()

                editFileList.setText(editFileList.text.toString() + "\n" + strFname)
            }
        }
    }
}























