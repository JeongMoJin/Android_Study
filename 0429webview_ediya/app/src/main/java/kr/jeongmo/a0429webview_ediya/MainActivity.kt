package kr.jeongmo.a0429webview_ediya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var link01: TextView
    lateinit var link02: TextView
    lateinit var link03: TextView
    lateinit var link04: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var url = "https://www.ediya.com/"

        webView = findViewById(R.id.webView)
        webView.webViewClient = myWebViewClient()

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.loadUrl(url)

        link01.findViewById<Button>(R.id.link01)
        link02.findViewById<Button>(R.id.link02)
        link03.findViewById<Button>(R.id.link03)
        link04.findViewById<Button>(R.id.link04)
    }
    class myWebViewClient : WebViewClient() {

    }
}