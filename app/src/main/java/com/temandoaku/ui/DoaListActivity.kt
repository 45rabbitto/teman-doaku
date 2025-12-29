package com.temandoaku.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.temandoaku.SharedPrefManager
import com.temandoaku.adapter.DoaAdapter
import com.temandoaku.data.AppDatabase
import com.temandoaku.databinding.ActivityDoaListBinding
import kotlinx.coroutines.launch

class DoaListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoaListBinding
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDoaListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefManager = SharedPrefManager(this)

        binding.ivBack.setOnClickListener { finish() }

        loadDoa()
    }

    private fun loadDoa() {
        val dao = AppDatabase.getDatabase(this).doaDao()
        val readDoas = sharedPrefManager.getReadDoas()

        lifecycleScope.launch {
            val doaList = dao.getAll()

            binding.rvDoaList.layoutManager =
                LinearLayoutManager(this@DoaListActivity)

            binding.rvDoaList.adapter =
                DoaAdapter(
                    doaList.toMutableList(),
                    readDoas,
                    dao
                )
        }
    }
}
