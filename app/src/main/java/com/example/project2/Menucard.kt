package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Menucard : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var arrayList: ArrayList<menudata>
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var menuadapter:Menuadapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menucard)

        val name=intent.getStringExtra("name")



        recyclerView=findViewById(R.id.recyclerView )
        arrayList= ArrayList()
        arrayList=setmenudata()

        linearLayoutManager= LinearLayoutManager(this)
        linearLayoutManager.orientation=LinearLayoutManager.VERTICAL
        recyclerView.layoutManager=linearLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=menuadapter
        menuadapter=Menuadapter(this,arrayList!!)
    }
    private fun setmenudata(): ArrayList<menudata> {
        var arrayList:ArrayList<menudata> = ArrayList()
        arrayList.add(menudata("Ringoz","Available","Ksh 10", "Add to cart"))
        arrayList.add(menudata("Ringoz","Available","Ksh 10", "Add to cart"))
        arrayList.add(menudata("Ringoz","Available","Ksh 10", "Add to cart"))
        arrayList.add(menudata("Ringoz","Available","Ksh 10", "Add to cart"))
        arrayList.add(menudata("Ringoz","Available","Ksh 10", "Add to cart"))
        arrayList.add(menudata("Ringoz","Available","Ksh 10", "Add to cart"))
        arrayList.add(menudata("Ringoz","Available","Ksh 10", "Add to cart"))
        return arrayList

    }
}
