package dts.pnj.lutfirobbani.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dts.pnj.lutfirobbani.DataAlumni
import dts.pnj.lutfirobbani.DetailDataAlumni
import dts.pnj.lutfirobbani.R
import dts.pnj.lutfirobbani.db.DataItem

class DataAdapter(private val context: Context, private val dataList: List<DataItem>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama: TextView = itemView.findViewById(R.id.sql_nama)
        val nim: TextView = itemView.findViewById(R.id.sql_nim)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_data_alumni, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = dataList[position]
        holder.nama.text = dataItem.nama
        holder.nim.text = dataItem.nim
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailDataAlumni::class.java)
            intent.putExtra("DATA_ID", dataItem.id)
            intent.putExtra("COLUMN_NAMA", dataItem.nama)
            intent.putExtra("COLUMN_ALAMAT", dataItem.alamat)
            intent.putExtra("COLUMN_NIM", dataItem.nim)
            intent.putExtra("COLUMN_TEMPAT", dataItem.tempat)
            intent.putExtra("COLUMN_TANGGAL", dataItem.tanggal)
            intent.putExtra("COLUMN_AGAMA", dataItem.agama)
            intent.putExtra("COLUMN_HP", dataItem.hp)
            intent.putExtra("COLUMN_MASUK", dataItem.masuk)
            intent.putExtra("COLUMN_KELUAR", dataItem.keluar)
            intent.putExtra("COLUMN_PEKERJAAN", dataItem.pekerjaan)
            intent.putExtra("COLUMN_JABATAN", dataItem.jabatan)
            holder.itemView.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
}
