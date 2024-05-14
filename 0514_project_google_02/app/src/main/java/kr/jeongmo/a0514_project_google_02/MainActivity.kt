package kr.jeongmo.a0514_project_google_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.model.GroundOverlay
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var googleMap: GoogleMap
    private lateinit var mapFragment: MapFragment
    private lateinit var mapList: ArrayList<GroundOverlay>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Google 지도 활용"

        mapFragment = fragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)
        mapList = ArrayList()
    }
}