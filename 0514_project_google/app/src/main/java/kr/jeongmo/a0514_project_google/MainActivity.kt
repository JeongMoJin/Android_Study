package kr.jeongmo.a0514_project_google

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.gms.maps.*
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

    override fun onMapReady(p0: GoogleMap?) {
        googleMap = p0!!
//        googleMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
//        googleMap.moveCamera(CameraUpdateFactory
//            .newLatLngZoom(LatLng(35.86952722, 128.6061745), 15f))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menu.add(0, 1, 0, "위성 지도")
        menu.add(0, 2, 0, "일반 지도")
        val subMenu = menu.addSubMenu("유명장소 바로가기")
        subMenu.add(0,3,0, "월드컵 경기장")
        subMenu.add(0,4,0, "두류공원")
        subMenu.add(0,5,0, "수성못")
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
            4 -> {
                googleMap.moveCamera(
                    CameraUpdateFactory
                        .newLatLngZoom(LatLng(35.86952722, 128.6061745), 15f)
                )
                return true
            }
            5 -> {
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