package com.temandoaku.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.temandoaku.R
import com.temandoaku.data.DoaEntity

class DoaAdapter(
    private val doaList: List<DoaEntity>
) : RecyclerView.Adapter<DoaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val doa = doaList[position]

        holder.tvTitle.text = doa.judul

        // 🔥 DI SINI KITA KIRIM GAMBAR KE DETAIL
        holder.itemView.setOnClickListener {

            val intent =
                Intent(holder.itemView.context, DoaDetailActivity::class.java)

            intent.putExtra("DOA_TITLE", doa.judul)
            intent.putExtra("DOA_ARABIC", doa.arab)
            intent.putExtra("DOA_LATIN", doa.latin)
            intent.putExtra("DOA_TRANSLATION", doa.arti)
            intent.putExtra("DOA_IMAGE", doa.imageRes)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = doaList.size
}
