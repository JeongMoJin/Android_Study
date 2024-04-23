package kr.jeongmo.a0423date_time

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var chronometer1 : Chronometer
    lateinit var btnStart : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var calendarView1 : CalendarView
    lateinit var timePicker1 : TimePicker
    lateinit var btnEnd : Button
    lateinit var tvYear : TextView
    lateinit var tvMonth : TextView
    lateinit var tvDay : TextView
    lateinit var tvHour : TextView
    lateinit var tvMinute : TextView
    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "시간 예약"

        // 버튼
        btnStart = findViewById(R.id.btnStart)
        btnEnd = findViewById(R.id.btnEnd)

        // 크로노미터
        chronometer1 = findViewById(R.id.chronometer1)

        // 라디오버튼 2개
        rdoCal = findViewById(R.id.rdoCal)
        rdoTime = findViewById(R.id.rdoTime)

        // FrameLayout의 2개 위젯
        timePicker1 = findViewById(R.id.timePicker1)
        calendarView1 = findViewById(R.id.calendarView1)

        // 텍스트뷰 중에서 연,월,일,시,분, 숫자
        tvYear = findViewById(R.id.tvYear)
        tvMonth = findViewById(R.id.tvMonth)
        tvDay = findViewById(R.id.tvDay)
        tvHour = findViewById(R.id.tvHour)
        tvMinute = findViewById(R.id.tvMinute)

        // 처음에는 2개를 안 보이게 설정
        timePicker1.visibility = View.INVISIBLE
        calendarView1.visibility = View.INVISIBLE

        rdoCal.setOnClickListener {
            timePicker1.visibility = View.INVISIBLE
            calendarView1.visibility = View.VISIBLE
        }

        rdoTime.setOnClickListener {
            timePicker1.visibility = View.VISIBLE
            calendarView1.visibility = View.INVISIBLE
        }

        // 타이머 설정
        btnStart.setOnClickListener {
            chronometer1.base = SystemClock.elapsedRealtime()
            chronometer1.start()
            chronometer1.setTextColor(Color.RED)
        }

        // 버튼을 클릭하면 날짜, 시간을 가져온다
        btnEnd.setOnClickListener {
            chronometer1.stop()
            chronometer1.setTextColor(Color.BLUE)

            tvYear.text = selectYear.toString()
            tvMonth.text = selectMonth.toString()
            tvDay.text = selectDay.toString()

            tvHour.text = timePicker1.currentHour.toString()
            tvMinute.text = timePicker1.currentMinute.toString()
        }

        calendarView1.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth
        }
    }
}



















