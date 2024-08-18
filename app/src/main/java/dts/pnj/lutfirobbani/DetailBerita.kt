package dts.pnj.lutfirobbani

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailBerita : AppCompatActivity(){

    private lateinit var detailjudul : TextView
    private lateinit var detaildecs : TextView
    private lateinit var detailimage : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_berita)

        detaildecs = findViewById(R.id.decs_detail_berita)
        detailjudul = findViewById(R.id.judul_detail_berita)
        detailimage = findViewById(R.id.gambar_detail_berita)

        val judul = intent.getStringExtra("judul")
        val decs = intent.getStringExtra("decs")
        val image = intent.getIntExtra("image", 0)

        detailjudul.text = judul
        detaildecs.text = decs
        detailimage.setImageResource(image)

    }
}