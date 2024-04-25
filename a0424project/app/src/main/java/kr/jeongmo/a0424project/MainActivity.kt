package kr.jeongmo.a0424project

import android.app.TabActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : TabActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a06_taphost)

        /* tab host */
        val tabHost = this.tabHost

        val tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
        tabSpecSong.setContent(R.id.tabSong)
        tabHost.addTab(tabSpecSong)

        val tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
        tabSpecArtist.setContent(R.id.tabArtist)
        tabHost.addTab(tabSpecArtist)

        val tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
        tabSpecAlbum.setContent(R.id.tabAlbum)
        tabHost.addTab(tabSpecAlbum)

        tabHost.currentTab = 0
    }
}