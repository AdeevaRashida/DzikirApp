package com.adeeva.idn.dzikirapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adeeva.idn.dzikirapp.adapter.DzikirDoaAdapter
import com.adeeva.idn.dzikirapp.model.DataDzikirDoa
import com.adeeva.idn.dzikirapp.model.DzikirDoa
import com.adeeva.idn.dzikirapp.R

class DzikirPetangActivity : AppCompatActivity() {

    private lateinit var rvDzikirPetang: RecyclerView

    private var listDzikirPetang: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikir_petang)

        rvDzikirPetang = findViewById(R.id.rv_dzikir_petang)

        listDzikirPetang.clear()
        listDzikirPetang.addAll(DataDzikirDoa.listDzikirPetang)

        rvDzikirPetang.layoutManager = LinearLayoutManager(this)
        rvDzikirPetang.adapter = DzikirDoaAdapter(listDzikirPetang)
        rvDzikirPetang.setHasFixedSize(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}