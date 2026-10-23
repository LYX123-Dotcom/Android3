package cn.edu.sicnu.cs.lyx.andriod3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val FIRST_MSG = "FIRST_MSG"
const val SECOND_MSG = "SECOND_MSG"

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        val first = findViewById<Button>(R.id.first)
        val second = findViewById<Button>(R.id.second)
        val third = findViewById<Button>(R.id.third)
        val fourth = findViewById<Button>(R.id.fourth)

        first.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(FIRST_MSG, editText.text.toString())
            startActivity(intent)
        }

        second.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, 0)
        }

        third.setOnClickListener {
            startActivity(Intent(this, FourthActivity::class.java))
        }

        fourth.setOnClickListener {
            startActivity(Intent(this, FifthActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (resultCode == 1) {
                textView.text = data?.getStringExtra(SECOND_MSG)
            }
        }
    }
}
