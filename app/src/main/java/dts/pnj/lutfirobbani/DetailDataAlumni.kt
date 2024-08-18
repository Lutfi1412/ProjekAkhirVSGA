package dts.pnj.lutfirobbani

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import dts.pnj.lutfirobbani.db.SQLiteHelper

class DetailDataAlumni : AppCompatActivity() {

    private lateinit var detailnama: AppCompatEditText
    private lateinit var detailnim: AppCompatEditText
    private lateinit var detailalamat: AppCompatEditText
    private lateinit var detailtempat: AppCompatEditText
    private lateinit var detailtanggal: AppCompatEditText
    private lateinit var detailagama: AppCompatEditText
    private lateinit var detailhp: AppCompatEditText
    private lateinit var detailmasuk: AppCompatEditText
    private lateinit var detailkeluar: AppCompatEditText
    private lateinit var detailpekerjaan: AppCompatEditText
    private lateinit var detailjabatan: AppCompatEditText
    private lateinit var ubah: AppCompatButton
    private lateinit var hapus: AppCompatButton
    private lateinit var dbHelper: SQLiteHelper
    private var dataId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_data_alumni)


        detailnama = findViewById(R.id.detail_nama)
        detailnim = findViewById(R.id.detail_nim)
        detailalamat = findViewById(R.id.detail_alamat)
        detailtempat = findViewById(R.id.detail_tempat)
        detailtanggal = findViewById(R.id.detail_tanggal)
        detailagama = findViewById(R.id.detail_agama)
        detailhp = findViewById(R.id.detail_nomor)
        detailmasuk = findViewById(R.id.detail_masuk)
        detailkeluar = findViewById(R.id.detail_lulus)
        detailpekerjaan = findViewById(R.id.detail_pekerjaan)
        detailjabatan = findViewById(R.id.detail_jabatan)
        ubah = findViewById(R.id.ubah)
        hapus = findViewById(R.id.hapus)

        dbHelper = SQLiteHelper(this)

        val nama = intent.getStringExtra("COLUMN_NAMA")
        val nim = intent.getStringExtra("COLUMN_NIM")
        val alamat = intent.getStringExtra("COLUMN_ALAMAT")
        val tempat = intent.getStringExtra("COLUMN_TEMPAT")
        val tanggal = intent.getStringExtra("COLUMN_TANGGAL")
        val agama = intent.getStringExtra("COLUMN_AGAMA")
        val hp = intent.getStringExtra("COLUMN_HP")
        val masuk = intent.getStringExtra("COLUMN_MASUK")
        val keluar = intent.getStringExtra("COLUMN_KELUAR")
        val pekerjaan = intent.getStringExtra("COLUMN_PEKERJAAN")
        val jabatan = intent.getStringExtra("COLUMN_JABATAN")


        dataId = intent.getIntExtra("DATA_ID", -1)

        if (dataId == -1) {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
            return
        }


        detailnama.setText(nama)
        detailnim.setText(nim)
        detailalamat.setText(alamat)
        detailtempat.setText(tempat)
        detailtanggal.setText(tanggal)
        detailagama.setText(agama)
        detailhp.setText(hp)
        detailmasuk.setText(masuk)
        detailkeluar.setText(keluar)
        detailpekerjaan.setText(pekerjaan)
        detailjabatan.setText(jabatan)

        ubah.setOnClickListener {
            if (dataId != null) {
                val updatedNama = detailnama.text.toString()
                val updatedNim = detailnim.text.toString()
                val updatedAlamat = detailalamat.text.toString()
                val updatedTempat = detailtempat.text.toString()
                val updatedTanggal = detailtanggal.text.toString()
                val updatedAgama = detailagama.text.toString()
                val updatedHp = detailhp.text.toString()
                val updatedMasuk = detailmasuk.text.toString()
                val updatedKeluar = detailkeluar.text.toString()
                val updatedPekerjaan = detailpekerjaan.text.toString()
                val updatedJabatan = detailjabatan.text.toString()

                val isSuccess = dbHelper.updateData(
                    dataId!!,
                    updatedNama, updatedAlamat, updatedNim,
                    updatedTanggal, updatedTempat, updatedAgama,
                    updatedJabatan, updatedKeluar, updatedMasuk,
                    updatedPekerjaan, updatedHp
                )

                if (isSuccess) {
                    Toast.makeText(this, "Data berhasil diperbarui", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Gagal memperbarui data", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Data ID tidak valid", Toast.LENGTH_SHORT).show()
            }
        }

        hapus.setOnClickListener {
            if (dataId != null) {
                val isDeleted = dbHelper.deleteData(dataId!!)
                if (isDeleted) {
                    Toast.makeText(this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, DataAlumni::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Gagal menghapus data", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Data ID tidak valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
