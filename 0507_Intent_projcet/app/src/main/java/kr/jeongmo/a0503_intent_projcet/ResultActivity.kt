package kr.jeongmo.a0503_intent_projcet

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        val imgeIds = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9 )
        
        var idxBest = 0 // 최고점수 인덱스 저장
        var idxBestValue = 0 // 값 비교를 위해서

//        val textViewBest = findViewById<TextView>(R.id.textViewBest)
//        val imageViewBest = findViewById<ImageView>(R.id.imageViewBest)

        // 최고점 인덱스를 이용해서 이미지와 타이틀 변경
//        textViewBext.text = imageNames?.get(idxBest)
        // imageViewBest.setImageResource(imageIds[idxBest])

        // MainActivity에서 보낸 투표 결과 값을 받음
        title = "투표결과"
        val intent = intent
        val voteCounts = intent.getIntArrayExtra("voteCounts")
        val imageNames = intent.getStringArrayExtra("imageNames")

        val textViews = arrayOfNulls<TextView>(9)
        val ratingBars = arrayOfNulls<RatingBar>(9)

        // 9개의 TextView, RatingBar id 배열
        val textViewIds = arrayOf(R.id.textView1, R.id.textView2, R.id.textView3,
            R.id.textView4, R.id.textView5, R.id.textView6,
            R.id.textView7, R.id.textView8, R.id.textView9)
        val ratingBarIds = arrayOf(R.id.ratingBar1, R.id.ratingBar2, R.id.ratingBar3,
            R.id.ratingBar4, R.id.ratingBar5, R.id.ratingBar6,
            R.id.ratingBar7, R.id.ratingBar8, R.id.ratingBar9 )

        for (i in voteCounts!!.indices) {
            textViews[i] = findViewById(textViewIds[i])
            textViews[i]!!.text = imageNames!![i]

            ratingBars[i] = findViewById(ratingBarIds[i])
            ratingBars[i]!!.rating = voteCounts[i].toFloat()
        }

        val btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}