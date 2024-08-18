package dts.pnj.lutfirobbani.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "mydatabase.db"
        private const val TABLE_NAME = "data"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAMA = "nama"
        private const val COLUMN_ALAMAT = "alamat"
        private const val COLUMN_NIM = "nim"
        private const val COLUMN_TEMPAT = "tempat"
        private const val COLUMN_TANGGAL = "tanggal"
        private const val COLUMN_AGAMA = "agama"
        private const val COLUMN_HP = "hp"
        private const val COLUMN_MASUK = "masuk"
        private const val COLUMN_KELUAR = "keluar"
        private const val COLUMN_PEKERJAAN = "pekerjaan"
        private const val COLUMN_JABATAN = "jabatan"

        private const val TABLE_CREATE =
            "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAMA TEXT, $COLUMN_ALAMAT TEXT, $COLUMN_NIM TEXT, $COLUMN_TEMPAT TEXT, $COLUMN_TANGGAL TEXT, $COLUMN_PEKERJAAN TEXT, $COLUMN_AGAMA TEXT, $COLUMN_HP TEXT, $COLUMN_MASUK TEXT, $COLUMN_KELUAR TEXT, $COLUMN_JABATAN TEXT)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(nama: String, alamat: String, nim: String, tempat: String, tanggal: String, agama: String, hp: String, masuk: String, keluar: String, pekerjaan: String, jabatan: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAMA, nama)
            put(COLUMN_ALAMAT, alamat)
            put(COLUMN_NIM, nim)
            put(COLUMN_TEMPAT, tempat)
            put(COLUMN_TANGGAL, tanggal)
            put(COLUMN_AGAMA, agama)
            put(COLUMN_HP, hp)
            put(COLUMN_MASUK, masuk)
            put(COLUMN_KELUAR, keluar)
            put(COLUMN_PEKERJAAN, pekerjaan)
            put(COLUMN_JABATAN, jabatan)
        }
        val result = db.insert(TABLE_NAME, null, values)
        db.close()
        return result != -1L
    }

    fun getAllData(): List<DataItem> {
        val dataList = mutableListOf<DataItem>()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
                val nama = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAMA))
                val alamat = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALAMAT))
                val nim = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NIM))
                val tempat = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEMPAT))
                val tanggal = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TANGGAL))
                val agama = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AGAMA))
                val hp = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_HP))
                val masuk = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MASUK))
                val keluar = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_KELUAR))
                val pekerjaan = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PEKERJAAN))
                val jabatan = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_JABATAN))
                dataList.add(DataItem(id, nama, alamat, nim, tempat, tanggal, agama, hp, masuk, keluar, pekerjaan, jabatan))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return dataList
    }

    fun deleteData(id: Int): Boolean {
        val db = writableDatabase
        val result = db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(id.toString()))
        db.close()
        return result > 0
    }

    fun updateData(id: Int, nama: String, alamat: String, nim: String, tempat: String, tanggal: String, agama: String, hp: String, masuk: String, keluar: String, jabatan: String, pekerjaan: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAMA, nama)
            put(COLUMN_ALAMAT, alamat)
            put(COLUMN_NIM, nim)
            put(COLUMN_TEMPAT, tempat)
            put(COLUMN_TANGGAL, tanggal)
            put(COLUMN_AGAMA, agama)
            put(COLUMN_HP, hp)
            put(COLUMN_MASUK, masuk)
            put(COLUMN_KELUAR, keluar)
            put(COLUMN_PEKERJAAN, pekerjaan)
            put(COLUMN_JABATAN, jabatan)
        }
        val result = db.update(TABLE_NAME, values, "$COLUMN_ID=?", arrayOf(id.toString()))
        db.close()
        return result > 0
    }
}
