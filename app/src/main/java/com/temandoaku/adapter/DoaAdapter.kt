package com.temandoaku.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.temandoaku.R
import com.temandoaku.data.DoaDao
import com.temandoaku.data.DoaEntity
import com.temandoaku.ui.DoaDetailActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DoaAdapter(
    private val list: MutableList<DoaEntity>,
    private val readDoas: Set<Int>,
    private val dao: DoaDao
) : RecyclerView.Adapter<DoaAdapter.DoaViewHolder>() {

    // ================= VIEW HOLDER =================
    inner class DoaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvJudul: TextView = view.findViewById(R.id.tvJudul)
        val ivFavorite: ImageView = view.findViewById(R.id.ivFavorite)
    }

    // ================= CREATE VIEW =================
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doa, parent, false)
        return DoaViewHolder(view)
    }

    // ================= BIND VIEW =================
    override fun onBindViewHolder(holder: DoaViewHolder, position: Int) {
        val doa = list[position]

        // Judul doa
        holder.tvJudul.text = doa.judul

        // Status favorit
        holder.ivFavorite.setImageResource(
            if (doa.isFavorite)
                R.drawable.ic_star_filled
            else
                R.drawable.ic_star_border
        )

        // Klik ikon favorit
        holder.ivFavorite.setOnClickListener {
            val updated = doa.copy(isFavorite = !doa.isFavorite)
            list[position] = updated
            notifyItemChanged(position)

            CoroutineScope(Dispatchers.IO).launch {
                dao.update(updated)
            }
        }

        // Klik item ke detail doa
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DoaDetailActivity::class.java)
            intent.putExtra("DOA_TITLE", doa.judul)
            intent.putExtra("DOA_ARABIC", doa.arab)
            intent.putExtra("DOA_LATIN", doa.latin)
            intent.putExtra("DOA_TRANSLATION", doa.arti)
            intent.putExtra("DOA_IMAGE", doa.imageRes)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size
}
