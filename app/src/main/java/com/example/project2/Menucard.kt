package com.example.project2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
//import com.example.project2.databinding.ActivityMenucardBinding
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase

class Menucard : AppCompatActivity() {

    private lateinit var menuListView: ListView
    private lateinit var orderListView: ListView
    private lateinit var orderAdapter: ArrayAdapter<String>
    private lateinit var placeOrderButton: Button
    // private lateinit var binding:ActivityMenucardBinding
    //private lateinit var database: DatabaseReference

    private val menuItems = arrayOf(
        "TEA KSH.50",
        "MANDAZI KSH.10",
        "NESCAFE SATCHETS KSH.5",
        "WATER KSH.28",
        "RINGOZ KSH.10"
    )
    private val selectedItems = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menucard)
        // binding=ActivityMenucardBinding.inflate(layoutInflater)
        //    setContentView(binding.root)

        //  binding.placeOrderButton.setOnClickListener {
        //     val order= listOf(binding.orderListView).toString()

        //    database=FirebaseDatabase.getInstance().getReference("Order")
        //   val orderlist=database(order)
        //      database.child(order).setValue(orderlist).addOnSuccessListener {
        //       listOf(binding.orderListView).toString()
        //        Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()
        //    }.addOnFailureListener {
        //             Toast.makeText(this,"Failed to Save",Toast.LENGTH_SHORT).show()


        menuListView = findViewById(R.id.menuListView)
        orderListView = findViewById(R.id.orderListView)
        placeOrderButton = findViewById(R.id.placeOrderButton)

        // Set up menu ListView
        val menuAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems)
        menuListView.adapter = menuAdapter

        // Set up order ListView
        orderAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, selectedItems)
        orderListView.adapter = orderAdapter

        // Add item to order when clicked
        menuListView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = menuItems[position]
            if (!selectedItems.contains(selectedItem)) {
                selectedItems.add(selectedItem)
                orderAdapter.notifyDataSetChanged()
            }
        }

        // Remove item from order when clicked
        orderListView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = selectedItems[position]
            selectedItems.remove(selectedItem)
            orderAdapter.notifyDataSetChanged()
        }

        //Place order button click listener
        placeOrderButton.setOnClickListener {
            if (selectedItems.isNotEmpty()) {
             //   Perform the necessary actions to place the order
                        Toast.makeText(this, "Order placed!", Toast.LENGTH_SHORT).show()
                selectedItems.clear()
                orderAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Please select items to order", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

