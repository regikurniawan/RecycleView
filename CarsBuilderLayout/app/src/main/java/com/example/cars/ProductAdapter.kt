package com.example.cars

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R.id.buttonOrder
import com.example.recycleview.Product

// ProductAdapter.kt
class ProductAdapter(private val context: Context, private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.btnPesan.setOnClickListener {
            val intent = Intent(context, ProductDetail::class.java)

            // Sertakan data produk ke dalam intent
            intent.putExtra("gambar", product.imageResId)
            intent.putExtra("nama", product.name)
            intent.putExtra("harga", product.price)
            intent.putExtra("keterangan", product.detail)

            // Jalankan aktivitas DetailProdukActivity dengan intent yang telah dikonfigurasi
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Define views in the item layout (item_product.xml)
        val btnPesan: Button = view.findViewById(buttonOrder)
        // Add other views as needed
    }
}
