package com.temandoaku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.temandoaku.databinding.ActivityDoaListBinding

class DoaListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoaListBinding
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoaListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefManager = SharedPrefManager(this)

        // Tombol kembali
        binding.ivBack.setOnClickListener {
            finish()
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val readDoas = sharedPrefManager.getReadDoas()

        // Buat adapter sederhana dulu
        val doaAdapter = object : androidx.recyclerview.widget.RecyclerView.Adapter<DoaViewHolder>() {
            override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): DoaViewHolder {
                val view = android.view.LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_doa, parent, false)
                return DoaViewHolder(view)
            }

            override fun onBindViewHolder(holder: DoaViewHolder, position: Int) {
                val doa = DataSource.doaList[position]
                holder.bind(doa, doa.id in readDoas)

                holder.itemView.setOnClickListener {
                    // Tandai doa sebagai sudah dibaca
                    sharedPrefManager.markDoaAsRead(doa.id)

                    // Navigasi ke detail doa
                    val intent = Intent(this@DoaListActivity, DoaDetailActivity::class.java).apply {
                        putExtra("DOA_ID", doa.id)
                        putExtra("DOA_TITLE", doa.title)
                        putExtra("DOA_ARABIC", doa.arabic)
                        putExtra("DOA_LATIN", doa.latin)
                        putExtra("DOA_TRANSLATION", doa.translation)
                        putExtra("DOA_IMAGE", doa.imageResId)
                    }
                    startActivity(intent)
                }
            }

            override fun getItemCount() = DataSource.doaList.size
        }

        binding.rvDoaList.apply {
            layoutManager = LinearLayoutManager(this@DoaListActivity)
            adapter = doaAdapter
            setHasFixedSize(true)
        }
    }

    class DoaViewHolder(itemView: android.view.View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        private val tvTitle: android.widget.TextView = itemView.findViewById(R.id.tvTitle)
        private val tvCategory: android.widget.TextView = itemView.findViewById(R.id.tvCategory)
        private val tvArabicPreview: android.widget.TextView = itemView.findViewById(R.id.tvArabicPreview)
        private val ivRead: android.widget.ImageView = itemView.findViewById(R.id.ivRead)

        fun bind(doa: Doa, isRead: Boolean) {
            tvTitle.text = doa.title
            tvCategory.text = doa.category
            tvArabicPreview.text = doa.arabic

            if (isRead) {
                ivRead.visibility = android.view.View.VISIBLE
            } else {
                ivRead.visibility = android.view.View.INVISIBLE
            }
        }
    }
}