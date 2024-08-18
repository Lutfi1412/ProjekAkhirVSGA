package dts.pnj.lutfirobbani

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import dts.pnj.lutfirobbani.db.SQLiteHelper

class TambahData : AppCompatActivity() {

    private lateinit var nim: AppCompatEditText
    private lateinit var nama: AppCompatEditText
    private lateinit var ttl: AppCompatEditText
    private lateinit var tanggal: AppCompatEditText
    private lateinit var alamat: AppCompatEditText
    private lateinit var agama: AppCompatEditText
    private lateinit var hp: AppCompatEditText
    private lateinit var masuk: AppCompatEditText
    private lateinit var keluar: AppCompatEditText
    private lateinit var pekerjaan: AppCompatEditText
    private lateinit var jabatan: AppCompatEditText
    private lateinit var simpan: AppCompatButton
    private lateinit var dbHelper: SQLiteHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.tambah_data)

        nim = findViewById(R.id.nim)
        nama = findViewById(R.id.nama)
        ttl = findViewById(R.id.tempat)
        tanggal = findViewById(R.id.tanggal)
        alamat = findViewById(R.id.alamat)
        agama = findViewById(R.id.agama)
        hp = findViewById(R.id.nomor)
        masuk = findViewById(R.id.masuk)
        keluar = findViewById(R.id.lulus)
        pekerjaan = findViewById(R.id.pekerjaan)
        jabatan = findViewById(R.id.jabatan)
        simpan = findViewById(R.id.simpan)

        // Inisialisasi dbHelper
        dbHelper = SQLiteHelper(this)

        simpan.setOnClickListener {
            val namaText = nama.text.toString()
            val nimetext = nim.text.toString()
            val ttltext = ttl.text.toString()
            val tanggaltext = tanggal.text.toString()
            val alamatText = alamat.text.toString()
            val agamatext = agama.text.toString()
            val hptext = hp.text.toString()
            val masuktext = masuk.text.toString()
            val keluartext = keluar.text.toString()
            val pekerjaantext = pekerjaan.text.toString()
            val jabatantext = jabatan.text.toString()

            if (namaText.isEmpty() || alamatText.isEmpty() || nimetext.isEmpty() || ttltext.isEmpty() || tanggaltext.isEmpty() || hptext.isEmpty() || agamatext.isEmpty() || masuktext.isEmpty() || keluartext.isEmpty() || pekerjaantext.isEmpty() || jabatantext.isEmpty()) {
                Toast.makeText(this, "Lengkapi Data", Toast.LENGTH_SHORT).show()
            } else {
                dbHelper.insertData(namaText, alamatText, nimetext, ttltext, tanggaltext, agamatext, hptext, masuktext, keluartext, pekerjaantext, jabatantext)
                Toast.makeText(this, "Data Telah Ditambahkan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
