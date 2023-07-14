package com.example.project2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

//import com.example.project2.databinding.ActivityMenucardBinding
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase

class Menucard : AppCompatActivity() {

    private lateinit var menuListView: ListView
    private lateinit var orderListView: ListView
    private lateinit var orderAdapter: ArrayAdapter<String>
    private lateinit var placeOrderButton: Button
    // private lateinit var binding:ActivityMenucardBinding
    //private lateinit var database: DatabaseReferenceval itemData = getItemData(selectedItem)

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

        // Get the reference to the Firebase Realtime Database
        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        val databaseRef: DatabaseReference = database.reference


        // Assuming you have a ListView with id "listView" in your XML layout
        val listView: ListView = findViewById(R.id.menuListView)

// Assuming you have a Button with id "pushButton" in your XML layout
        val placeOrderB: Button = findViewById(R.id.placeOrderButton)

        var selectedItem: Menucard.Orderlist? = null

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            selectedItem = listView.getItemAtPosition(position) as Menucard.Orderlist
        }

        placeOrderB.setOnClickListener {
            selectedItem?.let { item ->
                val itemData = getItemData(item)

                // Push the data to the Firebase Realtime Database
                databaseRef.child("selectedItems").push().setValue(itemData)
            }
        }





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
        fun getItemData(selectedItem:Orderlist ): MutableMap<String, Any> {
            // Create a map to store the data
            val itemData: MutableMap<String, Any> = HashMap()

            // Add the selected item's data to the map
            itemData["order"] = selectedItem



            return itemData
        }

        data class Orderlist(val order: String)
    }


