package com.example.cars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MobilAdapter (val listOS: ArrayList<Mobil>) : RecyclerView.Adapter<MobilAdapter.ListViewHolder>() {
        inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var nama: TextView = itemView.findViewById(R.id.ProductName)
            var detail: TextView = itemView.findViewById(R.id.productdetail)
            var gambar: ImageView = itemView.findViewById(R.id.imageProduct)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
            return ListViewHolder(view)
        }

        override fun getItemCount(): Int {
            return listOS.size
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val ListOS = listOS[position]
            Glide.with(holder.itemView.context)
                .load(ListOS.imagecar)
                .apply(RequestOptions().override(55, 55))
                .into(holder.gambar)
            holder.nama.text = ListOS.nama
            holder.detail.text = ListOS.detail
        }
}