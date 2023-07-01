package com.example.project2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class  Menuadapter (var context:Context, var arrayList: ArrayList<menudata>):RecyclerView.Adapter<Menuadapter.Viewholder>() {




     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.menulayout,parent,false)
         return Viewholder(view)
    }

     override fun getItemCount(): Int {
         return arrayList.size
     }

     override fun onBindViewHolder(holder: Viewholder, position: Int) {
         var menu: menudata =arrayList.get(position)
         holder.product.text=menu.product
         holder.availability.text=menu.availability
         holder.price.text=menu.price
         holder.button.text=menu.button
    }

     class Viewholder(itemView:View):RecyclerView.ViewHolder(itemView){
         var  product:TextView=itemView.findViewById<TextView>(R.id.textView)
         var  availability:TextView=itemView.findViewById<TextView>(R.id.textView2)
         var  price:TextView=itemView.findViewById<TextView>(R.id.textView3)
         var button:Button=itemView.findViewById(R.id.btnAddtocart)
     }


}