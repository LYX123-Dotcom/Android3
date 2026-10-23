package cn.edu.sicnu.cs.lyx.andriod3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val editText = findViewById<EditText>(R.id.editText)
        val confirm = findViewById<Button>(R.id.confirm)

        confirm.setOnClickListener {
            val intent = Intent()
            intent.putExtra(SECOND_MSG, editText.text.toString())
            setResult(1, intent)
            finish()
        }
    }
}
