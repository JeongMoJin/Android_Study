package kr.jeongmo.a0502project

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log.println
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var btnPrev : Button
    lateinit var btnNext : Button
    lateinit var MyPictureView : MyPictureView
    var curIndex : Int = 1
    var imageFiles : Array<File>? = null

    lateinit var imageFname : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "간단 이미지 뷰어"
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Context.MODE_PRIVATE
        )

        btnPrev = findViewById(R.id.btnPrev)
        btnNext = findViewById(R.id.btnNext)
        MyPictureView = findViewById(R.id.myPictureView)

        imageFiles =
            File(Environment.getExternalStorageDirectory().absolutePath + "/Pictures").listFiles()

        // 파일 목록 출력
        var fileName = ""
        for (i in imageFiles!!.indices) {
            if (imageFiles!![i].isDirectory == true)
                fileName = "<폴더> " + imageFiles!![i].toString()
            else
                fileName = "<파일> " + imageFiles!![i].toString()
        }
        MyPictureView.imagePath = imageFiles!![curIndex].toString()

        btnPrev.setOnClickListener {
            if (curIndex <= 1) {
                Toast.makeText(applicationContext, "첫번째 그림입니다.", Toast.LENGTH_SHORT).show()
            } else {
                MyPictureView.imagePath = imageFiles!![--curIndex].toString()
                MyPictureView.invalidate()
            }
        }

        btnNext.setOnClickListener {
            if (curIndex >= imageFiles!!.size-1) {
                Toast.makeText(applicationContext, "마지막 그림입니다.", Toast.LENGTH_SHORT).show()
            }  else {
                MyPictureView.imagePath = imageFiles!![++curIndex].toString()
                MyPictureView.invalidate()
            }
        }
    }
}