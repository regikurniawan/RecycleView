package com.example.cars

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleview.Product

class ProductDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailproduk)

        val product = intent.getParcelableExtra<Product>("product")

        if (product != null) {
            val imageView: ImageView = findViewById(R.id.imageViewDetail)
            val textViewName: TextView = findViewById(R.id.textViewDetailName)
            val textViewPrice: TextView = findViewById(R.id.textViewDetailPrice)
            val textDetailSpec: TextView = findViewById(R.id.detailspesifikasi)

            imageView.setImageResource(product.imageResId ?: 0)
            textViewName.text = product.name
            textViewPrice.text = product.price.toString()
            textDetailSpec.text = product.detail
        } else {
            finish() // Menutup aktivitas ProductDetail
            return // Menghentikan eksekusi kode setelah finish()
        }
    }
}