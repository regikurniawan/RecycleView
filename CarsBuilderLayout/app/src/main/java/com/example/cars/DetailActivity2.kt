package com.example.cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)

        val image = findViewById<ImageView>(R.id.gambarmobil)
        val name = findViewById<TextView>(R.id.namamobil)
        val desc = findViewById<TextView>(R.id.detailmobil)
        val price = findViewById<TextView>(R.id.hargamobil)
//        val order = findViewById<Button>(R.id.btnbeli)
    }

}