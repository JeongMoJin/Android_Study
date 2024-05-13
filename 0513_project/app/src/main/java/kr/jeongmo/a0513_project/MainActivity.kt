package kr.jeongmo.a0513_project

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "갤러리 영화 포스터"

        val gallery = findViewById<Gallery>(R.id.gallery)
        val myGalleryAdapter = MyGalleryAdapter(this)
        gallery.adapter = myGalleryAdapter
    }
    inner class MyGalleryAdapter(val context: Context): BaseAdapter() {
        val posterId = arrayOf(
            R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
            R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,
            R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
            R.drawable.mov10,R.drawable.mov11,R.drawable.mov12,
        )
        override fun getCount(): Int {
            return posterId.size
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val imageView = ImageView(context)
            imageView.layoutParams = Gallery.LayoutParams(200,300)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(5,5,5,5)
            imageView.setImageResource(posterId[p0])

            imageView.setOnTouchListener { v, event ->
                val imageViewPoster = findViewById<ImageView>(R.id.imageViewPoster)
                imageViewPoster.scaleType = ImageView.ScaleType.FIT_CENTER
                imageViewPoster.setImageResource(posterId[p0])
                false
            }

            return imageView
        }





















    }
}