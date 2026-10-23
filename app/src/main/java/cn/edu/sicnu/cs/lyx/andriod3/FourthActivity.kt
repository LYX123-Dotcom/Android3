package cn.edu.sicnu.cs.lyx.andriod3

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FourthActivity : AppCompatActivity() {

    private lateinit var ivPhoto: ImageView
    private var photoBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        ivPhoto = findViewById(R.id.ivPhoto)
        findViewById<Button>(R.id.btnTakePhoto).setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            @Suppress("DEPRECATION")
            val bitmap = data?.extras?.get("data") as? Bitmap
            if (bitmap != null) {
                photoBitmap = bitmap
                ivPhoto.setImageBitmap(bitmap)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (photoBitmap != null) {
            outState.putParcelable("photo", photoBitmap)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        @Suppress("DEPRECATION")
        val bitmap = savedInstanceState.getParcelable<Bitmap>("photo")
        if (bitmap != null) {
            photoBitmap = bitmap
            ivPhoto.setImageBitmap(bitmap)
        }
    }
}
