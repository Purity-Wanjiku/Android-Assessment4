package com.example.anitab_api_products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anitab_api_products.databinding.ProductlistBinding
import com.squareup.picasso.Picasso

class ProductAdapter (val products: List<Product>): RecyclerView.Adapter<ProductViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var binding = ProductlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        var binding = holder.binding
        binding.tvTitle.text = product.title
        binding.tvdescription.text = product.description
        binding.tvPrice.text = product.price.toString()

        Picasso.get().load(product.thumbnail).into(binding.ivProductImage)
//        Picasso.get().load(data.thumbnail).into(binding.ivProductImage)
        // Bind the data to the views inside the view holder
        // Example: holder.titleTextView.text = product.title
    }

    override fun getItemCount(): Int {
        return products.size
    }

}
class ProductViewHolder(var binding: ProductlistBinding) : RecyclerView.ViewHolder(binding.root) {

    // Declare the views inside the card_product.xml layout
    // Example: val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
}