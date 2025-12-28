package com.temandoaku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.temandoaku.R
import com.temandoaku.data.DoaEntity

class DoaAdapter(
    private val list: List<DoaEntity>
) : RecyclerView.Adapter<DoaAdapter.DoaViewHolder>() {

    inner class DoaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvJudul: TextView = view.findViewById(R.id.tvJudul)
        val tvArab: TextView = view.findViewById(R.id.tvArab)
        val tvLatin: TextView = view.findViewById(R.id.tvLatin)
        val tvArti: TextView = view.findViewById(R.id.tvArti)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doa, parent, false)
        return DoaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoaViewHolder, position: Int) {
        val doa = list[position]
        holder.tvJudul.text = doa.judul
        holder.tvArab.text = doa.arab
        holder.tvLatin.text = doa.latin
        holder.tvArti.text = doa.arti
    }

    override fun getItemCount(): Int = list.size
}
