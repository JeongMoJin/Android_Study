package kr.jeongmo.a0503_intent_projcet

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        // MainActivity에서 보낸 투표 결과 값을 받음
        title = "투표결과"
        val intent = intent
        val voteCounts = intent.getIntArrayExtra("voteCounts")
        val imageNames = intent.getStringArrayExtra("imageNames")

        val textViews = arrayOfNulls<TextView>(9)
        val ratingBars = arrayOfNulls<RatingBar>(9)

        // 결과 이미지뷰, 텍스트뷰
        val resultImageView:ImageView = findViewById(R.id.resultImageView)
        val resultTextView:TextView = findViewById(R.id.resultTextView)

        // 9개의 TextView, RatingBar id 배열
        val textViewIds = arrayOf(R.id.textView1, R.id.textView2, R.id.textView3,
            R.id.textView4, R.id.textView5, R.id.textView6,
            R.id.textView7, R.id.textView8, R.id.textView9)
        val ratingBarIds = arrayOf(R.id.ratingBar1, R.id.ratingBar2, R.id.ratingBar3,
            R.id.ratingBar4, R.id.ratingBar5, R.id.ratingBar6,
            R.id.ratingBar7, R.id.ratingBar8, R.id.ratingBar9 )

        // 이미지 리소스 배열
        val imageSrc = arrayOf(
            "@drawable/pic1","@drawable/pic2","@drawable/pic3",
            "@drawable/pic4","@drawable/pic5","@drawable/pic6",
            "@drawable/pic7","@drawable/pic8","@drawable/pic9",
        )

        // 이미지 버튼 Id 배열
        val imageIds = arrayOf(
            R.id.imageView1, R.id.imageView2, R.id.imageView3,
            R.id.imageView4, R.id.imageView5, R.id.imageView6,
            R.id.imageView7, R.id.imageView8, R.id.imageView9
        )

        // 이미지 리소스 배열
        val imageSr = arrayOf(
            R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,
            R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,
            R.drawable.pic7,R.drawable.pic8,R.drawable.pic9,
        )

        for (i in voteCounts!!.indices) {
            textViews[i] = findViewById(textViewIds[i])
            textViews[i]!!.text = imageNames!![i]

            ratingBars[i] = findViewById(ratingBarIds[i])
            ratingBars[i]!!.rating = voteCounts[i].toFloat()
        }

        // 최대값 구하는 코드
        var maxNum = 0
        for (i in voteCounts!!.indices) {
            if (maxNum <= voteCounts[i]) {
                maxNum = voteCounts[i]
            }
        }

//        Log.d("맥스넘버", maxNum.toString())
        var maxIdx = voteCounts.indexOf(maxNum)
//        Log.d("maxIdx", maxIdx.toString())

        // 최종 결과 입력 코드
        resultTextView.text = imageNames!![maxIdx]
        resultImageView.setImageResource(imageSr[maxIdx])

        val btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}