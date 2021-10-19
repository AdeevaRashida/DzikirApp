package com.adeeva.idn.dzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.adeeva.idn.dzikirapp.UI.DoaHarianActivity
import com.adeeva.idn.dzikirapp.UI.DzikirPagiPetangActivity
import com.adeeva.idn.dzikirapp.UI.QauliyahActivity
import com.adeeva.idn.dzikirapp.model.Artikel
import com.adeeva.idn.dzikirapp.UI.DzikirSetiapSaatActivity
import com.adeeva.idn.dzikirapp.ui.detail.DetailArtikelActivity

class MainActivity : AppCompatActivity() {

    private lateinit var llDzikirDoaShalat: LinearLayout
    private lateinit var llDzikirDoaHarian: LinearLayout
    private lateinit var llDzikirSetiapSaat: LinearLayout
    private lateinit var llDzikirPagiPetang: LinearLayout
    private lateinit var llDotsSlider: LinearLayout

    private lateinit var vpArtikel: ViewPager2

    private var artikelArray: ArrayList<Artikel> = arrayListOf()

    private lateinit var dotsSlider: Array<ImageView?>
    private var dotsCount = 0

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (dot in 0 until dotsCount) {
                dotsSlider[dot]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext, R.drawable.non_active_dot
                    )
                )
            }

            dotsSlider[position]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.active_dot
                )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
        setUpViewPager()
    }

    private fun initView() {
        llDzikirDoaShalat = findViewById(R.id.llDzikirDoaSholat)
        llDzikirDoaShalat.setOnClickListener {
            startActivity(Intent(this, QauliyahActivity::class.java))
        }

        llDzikirDoaHarian = findViewById(R.id.llDzikirDoaHarian)
        llDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this, DoaHarianActivity::class.java))
        }

        llDzikirSetiapSaat = findViewById(R.id.llDzikirSetiapSaat)
        llDzikirSetiapSaat.setOnClickListener {
            startActivity(Intent(this, DzikirSetiapSaatActivity::class.java))
        }

        llDzikirPagiPetang = findViewById(R.id.llDzikirPagiPetang)
        llDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this, DzikirPagiPetangActivity::class.java))
        }

        llDotsSlider = findViewById(R.id.llSliderDot)
        vpArtikel = findViewById(R.id.vpArtikel)
    }

    private fun initData() {
        val image = resources.obtainTypedArray(R.array.img_artikel)
        val title = resources.getStringArray(R.array.title_artikel)
        val desc = resources.getStringArray(R.array.desc_artikel)

        artikelArray.clear()
        for (data in title.indices) {
            artikelArray.add(
                Artikel(
                    image.getResourceId(data, 0),
                    title[data],
                    desc[data]
                )
            )
        }
        image.recycle()
    }

    private fun setUpViewPager() {
        val artikelAdapter = ArtikelAdapter(artikelArray)
        artikelAdapter.setOnItemClickCallBack(object : OnItemClickCallBack {
            override fun onItemClicked(data: Artikel) {
                val intent = Intent(applicationContext, DetailArtikelActivity::class.java)

                intent.putExtra("data", data)
                startActivity(intent)
            }
        })

        vpArtikel.apply {
            adapter = artikelAdapter
            registerOnPageChangeCallback(slidingCallback)
        }

        dotsCount = artikelArray.size
        dotsSlider = arrayOfNulls(dotsCount)

        for (i in 0 until dotsCount) {
            dotsSlider[i] = ImageView(this)
            dotsSlider[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.non_active_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            llDotsSlider.addView(dotsSlider[i], params)
        }

        dotsSlider[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.active_dot
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }
}