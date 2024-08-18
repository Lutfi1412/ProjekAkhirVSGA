package dts.pnj.lutfirobbani

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dts.pnj.lutfirobbani.adapter.DataAdapter
import dts.pnj.lutfirobbani.db.DataItem
import dts.pnj.lutfirobbani.db.SQLiteHelper

class DataAlumni : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var dbHelper: SQLiteHelper


    private fun inisialisasi() {
        recycler = findViewById(R.id.recycler)
        dbHelper = SQLiteHelper(this)

        recycler.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(recycler.context, LinearLayoutManager.VERTICAL)
        recycler.addItemDecoration(dividerItemDecoration)
    }

    private fun loadData() {
        val dataList: List<DataItem> = dbHelper.getAllData()
        val adapter = DataAdapter(this, dataList)
        recycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.data_alumni)

        inisialisasi()
    }
}