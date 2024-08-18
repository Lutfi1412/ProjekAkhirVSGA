package dts.pnj.lutfirobbani

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dts.pnj.lutfirobbani.adapter.DataAdapterBerita
import dts.pnj.lutfirobbani.db.DataItemBerita

class Home : AppCompatActivity() {

    private lateinit var home : AppCompatButton
    private lateinit var profile : AppCompatButton
    private lateinit var berita : AppCompatButton
    private lateinit var profilenama : AppCompatEditText
    private lateinit var profilenim : AppCompatEditText
    private lateinit var profilekelas : AppCompatEditText
    private lateinit var profileemail : AppCompatEditText
    private lateinit var logout : AppCompatButton
    private lateinit var toolbar: Toolbar
    private lateinit var layoutberita : RecyclerView
    private lateinit var listberita : ArrayList<DataItemBerita>
    private lateinit var adapterberita : DataAdapterBerita

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)

        profile = findViewById(R.id.profile)
        home = findViewById(R.id.home)
        berita = findViewById(R.id.berita)
        logout = findViewById(R.id.logout)

        layoutberita = findViewById(R.id.layoutberita)
        layoutberita.layoutManager = GridLayoutManager(this, 2)
        listberita = ArrayList()
        addData()
        adapterberita = DataAdapterBerita(listberita)
        layoutberita.adapter = adapterberita

        val nama = intent.getStringExtra("nama")
        val nim = intent.getStringExtra("nim")
        val kelas = intent.getStringExtra("kelas")
        val email = intent.getStringExtra("email")

        profilenama = findViewById(R.id.namaprofile)
        profilenim = findViewById(R.id.nimprofile)
        profilekelas = findViewById(R.id.kelasprofile)
        profileemail = findViewById(R.id.emailprofile)


        val layoutBerita = findViewById<View>(R.id.layoutberita)
        val layoutProfile = findViewById<View>(R.id.layoutprofile)
        val layoutHome = findViewById<View>(R.id.layouthome)

        profile.setOnClickListener{
            layoutProfile.visibility = View.VISIBLE
            layoutBerita.visibility = View.GONE
            layoutHome.visibility = View.GONE

            profilenama.setText(nama)
            profilenim.setText(nim)
            profilekelas.setText(kelas)
            profileemail.setText(email)
        }
        home.setOnClickListener{
            layoutProfile.visibility = View.GONE
            layoutBerita.visibility = View.GONE
            layoutHome.visibility = View.VISIBLE
        }
        berita.setOnClickListener{
            layoutProfile.visibility = View.GONE
            layoutBerita.visibility = View.VISIBLE
            layoutHome.visibility = View.GONE
        }

        logout.setOnClickListener {
            finish()
        }

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = null
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tambah_data -> {
                val intent = Intent(this, TambahData::class.java)
                startActivity(intent)
                true
            }
            R.id.action_data_alumni -> {
                val intent = Intent(this, DataAlumni::class.java)
                startActivity(intent)
                true
            }
            R.id.action_logout -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun addData() {

        val description1 = getString(R.string.desc1)
        val title1 = getString(R.string.tittle1)

        val description2 = getString(R.string.desc2)
        val title2 = getString(R.string.tittle2)

        val description3 = getString(R.string.desc3)
        val title3 = getString(R.string.tittle3)

        val description4 = getString(R.string.desc4)
        val title4 = getString(R.string.tittle4)

        val description5 = getString(R.string.desc5)
        val title5 = getString(R.string.tittle5)

        val description6 = getString(R.string.desc6)
        val title6 = getString(R.string.tittle6)

        val description7 = getString(R.string.desc7)
        val title7 = getString(R.string.tittle7)

        val description8 = getString(R.string.desc8)
        val title8 = getString(R.string.tittle8)

        val description9 = getString(R.string.desc9)
        val title9 = getString(R.string.tittle9)

        val description10 = getString(R.string.desc10)
        val title10 = getString(R.string.tittle10)

        val items = listOf(
            Triple(R.drawable.satu,title1, description1),
            Triple(R.drawable.dua,title2, description2),
            Triple(R.drawable.tiga,title3, description3),
            Triple(R.drawable.empat, title4, description4),
            Triple(R.drawable.lima, title5, description5),
            Triple(R.drawable.enam,title6, description6),
            Triple(R.drawable.tujuh,title7, description7),
            Triple(R.drawable.delapan,title8, description8),
            Triple(R.drawable.sembilan,title9, description9),
            Triple(R.drawable.sepuluh,title10, description10)
        )
        items.forEach { (image, title, desc) ->
            listberita.add(DataItemBerita(image, title, desc))
        }
    }
}
