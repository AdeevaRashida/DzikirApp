package com.adeeva.idn.dzikirapp.UI

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.adeeva.idn.dzikirapp.ui.detail.DzikirPagiActivity
import com.adeeva.idn.dzikirapp.ui.detail.DzikirPetangActivity
import com.adeeva.idn.dzikirapp.R

class DzikirPagiPetangActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_dzikir_pagi_petang)

        val cvDzikirPagi = findViewById<CardView>(R.id.cv_dzikir_pagi)
        cvDzikirPagi.setOnClickListener(this)
        val cvDzikirPetang = findViewById<CardView>(R.id.cv_dzikir_petang)
        cvDzikirPetang.setOnClickListener(this)
        val btnDzikirPagi = findViewById<ImageButton>(R.id.btn_dzikir_pagi)
        btnDzikirPagi.setOnClickListener(this)
        val btnDzikirPetang = findViewById<ImageButton>(R.id.btn_dzikir_petang)
        btnDzikirPetang.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cv_dzikir_pagi -> startActivity(Intent(this, DzikirPagiActivity::class.java))
            R.id.btn_dzikir_pagi -> startActivity(Intent(this, DzikirPagiActivity::class.java))
            R.id.cv_dzikir_petang -> startActivity(Intent(this, DzikirPetangActivity::class.java))
            R.id.btn_dzikir_petang -> startActivity(Intent(this, DzikirPetangActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}