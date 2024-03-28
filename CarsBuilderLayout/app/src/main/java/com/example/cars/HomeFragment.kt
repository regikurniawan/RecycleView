package com.example.cars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.Product

// HomeFragment.kt
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragmenthomelayout, container, false)

        // Set up RecyclerView and adapter for the list of products
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ProductAdapter(requireContext(), getProductList())

        return view
    }

    // Replace this with your actual product data
    private fun getProductList(): List<Product> {
        return listOf(
            Product(R.drawable.ferrari_daytona, "Ferarri Daytona SP3", "$1.500.000", "At the 1967 24 Hours of Daytona, " +
                    "Ferrari took the top three places in the first round of the International World Sports Car Championship. The 330 P3/4, 330 P4" +
                    " and 412 P that famously shot past the chequered flag side by side perfectly encapsulated the spirit of the sports prototypes of the 1960s, " +
                    "a decade now considered the golden era of closed wheel racing. The Ferrari Daytona SP3, the second car to join the limited edition Icona series, " +
                    "pays homage to the mid-rear-engined Ferrari V12 sports prototypes that earned the marque its unparalleled motor sport status."),
            Product(R.drawable.koenigsegg_jesko, "Koenigsegg Jesko", "$4.000.000", "The Koenigsegg Jesko is a limited production mid-engine sports car produced by Swedish automobile manufacturer Koenigsegg. "),
            Product(R.drawable.aventadorsvj, "Lamborghini Aventador SVJ", "$1.200.000", "The SVJ Roadster uses ultra-light carbon fiber for its bodywork and rigid removable roof. The body features larger air intakes and more extended side skirts, accentuated aerodynamic profiles and a lighter exhaust system mounted higher up.  ")

            )
    }

}
