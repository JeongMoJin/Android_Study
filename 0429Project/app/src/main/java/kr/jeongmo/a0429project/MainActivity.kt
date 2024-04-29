package kr.jeongmo.a0429project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var url = "https://www.starbucks.co.kr/index.do"

        webView = findViewById(R.id.webView)
        webView.webViewClient = myWebViewClient()

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.loadUrl(url)
    }
    class myWebViewClient : WebViewClient() {

    }



}