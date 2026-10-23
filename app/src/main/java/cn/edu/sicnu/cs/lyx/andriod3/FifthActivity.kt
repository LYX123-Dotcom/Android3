package cn.edu.sicnu.cs.lyx.andriod3

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FifthActivity : AppCompatActivity() {

    private var seconds = 0
    private var running = false
    private var wasRunning = false

    private lateinit var textViewTimer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        Log.d("life cycle", "onCreate")

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }

        textViewTimer = findViewById(R.id.textView_timer)
        val buttonStart = findViewById<Button>(R.id.button_start)
        val buttonStop = findViewById<Button>(R.id.button_stop)
        val buttonRestart = findViewById<Button>(R.id.button_restart)

        runTimer()

        buttonStart.setOnClickListener {
            running = true
        }

        buttonStop.setOnClickListener {
            running = false
        }

        buttonRestart.setOnClickListener {
            running = true
            seconds = 0
        }
    }

    private fun runTimer() {
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                textViewTimer.text = String.format("%02d:%02d:%02d", hours, minutes, secs)
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("life cycle", "onSaveInstanceState")
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }

    override fun onStart() {
        super.onStart()
        if (wasRunning) {
            running = true
        }
    }

    override fun onStop() {
        super.onStop()
        wasRunning = running
        running = false
    }
}
