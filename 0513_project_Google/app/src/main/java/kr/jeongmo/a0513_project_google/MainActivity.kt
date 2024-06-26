package kr.jeongmo.a0513_project_google

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlay
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var googleMap: GoogleMap
    lateinit var mapFragment: MapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Google 지도 활용"

        mapFragment = fragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)




    }

    private fun vectorToBitmap(context: Context, vectorResId: Int): Bitmap? {
        /* 벡터 이미지를 비트맵으로 변경 */
        val drawable: Drawable? = ContextCompat.getDrawable(context, vectorResId)
            ?.let { DrawableCompat.wrap(it).mutate() }
        drawable?.let {
            val bitmap =
                Bitmap.createBitmap(it.intrinsicWidth, it.intrinsicHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            it.setBounds(0, 0, canvas.width, canvas.height)
            it.draw(canvas)
            return bitmap
        }
        return null
    }

    override fun onMapReady(p0: GoogleMap?) {
        googleMap = p0!!
//        googleMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
//        googleMap.moveCamera(CameraUpdateFactory
//            .newLatLngZoom(LatLng(35.86952722, 128.6061745), 15f))
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.setOnMapClickListener { point ->
            val videoMark = GroundOverlayOptions().image(
                BitmapDescriptorFactory.fromBitmap(vectorToBitmap(this, R.drawable.icon_camera))
            )
                .position(point, 100f, 100f)
            googleMap.addGroundOverlay(videoMark)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menu.add(0, 1, 0, "위성 지도")
        menu.add(0, 2, 0, "일반 지도")
        menu.add(0, 3, 0, "월드컵경기장 바로가기")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
                return true
            }
            2 -> {
                googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                return true
            }
            3 -> {
                googleMap.moveCamera(
                    CameraUpdateFactory
                        .newLatLngZoom(LatLng(35.86952722, 128.6061745), 15f)
                )
                return true
            }
        }
        return true
    }



}