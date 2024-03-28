package com.example.cars

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemSelectedListener

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R.id.bottomNavigationView

import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.FieldPosition

class MainActivity : AppCompatActivity(){

    private lateinit var rsv_osandroid: RecyclerView
    private var list : ArrayList<Mobil> = arrayListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rsv_osandroid = findViewById(R.id.viewmobil)
        rsv_osandroid.setHasFixedSize(true)



        list.addAll(DataMobil.listData)
        showRecycler()


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment())
                .commit()
        }

        val bottomNavigationView: BottomNavigationView = findViewById(bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment())
                        .commit()
                    true
                }

                R.id.basket -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, BasketFragment())
                        .commit()
                    true
                }

                else -> false
            }
        }


    }
    private fun showRecycler() {
        rsv_osandroid.layoutManager = LinearLayoutManager(this)
        val mobilAdapter = MobilAdapter(list)
        rsv_osandroid.adapter = mobilAdapter

        mobilAdapter.setOnItemClickListener(object : MobilAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                if (position >= 0 && position < list.size) {
                    val intent = Intent(this@MainActivity, DetailActivity2::class.java)
                    intent.putExtra("image", list[position].imagecar)
                    intent.putExtra("nama", list[position].nama)
                    intent.putExtra("detail", list[position].detail)
                    intent.putExtra("harga", list[position].harga)
                    startActivity(intent)
                }
            }
        })
    }



}