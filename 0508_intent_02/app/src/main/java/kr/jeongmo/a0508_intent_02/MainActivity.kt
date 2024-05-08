package kr.jeongmo.a0508_intent_02

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "암시적 인텐트 예제"
        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnWeb = findViewById<Button>(R.id.btnWeb)
        val btnGoogle = findViewById<Button>(R.id.btnGoogle)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val btnSms = findViewById<Button>(R.id.btnSms)
        val btnPhoto = findViewById<Button>(R.id.btnPhoto)

        btnCall.setOnClickListener {
            val uri = Uri.parse("tel:010-1234-5678")
            startActivity(Intent(Intent.ACTION_DIAL, uri))
        }

        btnWeb.setOnClickListener {
            val uri = Uri.parse("http://daum.net")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        btnGoogle.setOnClickListener {
            val uri = Uri.parse("https://maps.google.com/maps?q="
                    + 35.86606 + "," + 128.5938 + "&z=15")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        btnSearch.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "안드로이드")
            startActivity(intent)
        }

        btnSms.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body", "안녕하세요?")
            intent.setData(Uri.parse("smsto:010-1234-5678"))
            startActivity(intent)
        }

        btnPhoto.setOnClickListener {
            startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }
}











