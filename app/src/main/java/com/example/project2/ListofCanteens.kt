package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListofCanteens : AppCompatActivity() {
    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList:ArrayList<Listdata>
    lateinit var imageid:Array<Int>
    lateinit var text:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listof_canteens)

        imageid= arrayOf(
            //WEKA PICS HAPA KUTOKA DRAWABLE
            R.drawable.drawable,
            R.drawable.dekut,
            R.drawable.emobilis,
            R.drawable.jkuat,
            R.drawable.uon,
            R.drawable.usiu,
        )
        text= arrayOf(
            "Murubano Canteen",
            "JKUAT Canteen",
            "Emobilis Canteen",
            "UON Canteen",
            "USIU Canteen",
            "DEKUT Canteen"
        )
        newRecyclerview=findViewById(R.id.recyclerview)
        newRecyclerview.layoutManager= LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList= arrayListOf()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageid.indices){
            val canteenlist=Listdata(imageid[i],text[i])
            newArrayList.add(canteenlist)
        }
        var adapter=CustomAdapter(newArrayList)
        newRecyclerview.adapter=adapter
        adapter.setOnItemClickListener(object :CustomAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                //Toast.makeText(this@ListofCanteens," umeclick$position", Toast.LENGTH_LONG).show()
                val intent=Intent(this@ListofCanteens,Menucard::class.java)
                startActivity(intent)
            }


        })

 }
}
