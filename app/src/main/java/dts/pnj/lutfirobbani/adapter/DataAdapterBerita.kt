package dts.pnj.lutfirobbani.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dts.pnj.lutfirobbani.DetailBerita
import dts.pnj.lutfirobbani.DetailDataAlumni
import dts.pnj.lutfirobbani.R
import dts.pnj.lutfirobbani.db.DataItemBerita

class DataAdapterBerita (private val ListBerita:ArrayList<DataItemBerita>) : RecyclerView.Adapter<DataAdapterBerita.BeritaViewHolder>(){

    class BeritaViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.gambar1)
        val judul : TextView = itemView.findViewById(R.id.judul1)
        val desc : TextView = itemView.findViewById(R.id.desc1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_berita, parent, false)
        return BeritaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ListBerita.size
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val berita = ListBerita[position]
        holder.image.setImageResource(berita.image)
        holder.judul.text = if (berita.judul.length > 20) berita.judul.take(20) + "..." else berita.judul
        holder.desc.text = if (berita.desc.length > 55) berita.desc.take(55) + "..." else berita.desc
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailBerita::class.java)
            intent.putExtra("image", berita.image)
            intent.putExtra("judul", berita.judul)
            intent.putExtra("decs", berita.desc)
            holder.itemView.context.startActivity(intent)
        }
    }
}