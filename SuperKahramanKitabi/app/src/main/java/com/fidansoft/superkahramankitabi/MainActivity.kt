package com.fidansoft.superkahramankitabi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superKahramanListesi = ArrayList<String>()
        superKahramanListesi.add("Aquaman")
        superKahramanListesi.add("Batman")
        superKahramanListesi.add("Ironman")
        superKahramanListesi.add("Spiderman")
        superKahramanListesi.add("Superman")


        //Verimsiz tanımlamalar
       /* val aquamanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.aquaman)
        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.batman)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ironman)
        val spidermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.spiderman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.superman)

        val superKahramanGorselleri = ArrayList<Bitmap>()
        superKahramanGorselleri.add(aquamanBitmap)
        superKahramanGorselleri.add(batmanBitmap)
        superKahramanGorselleri.add(ironmanBitmap)
        superKahramanGorselleri.add(spidermanBitmap)
        superKahramanGorselleri.add(supermanBitmap)
*/

        //Verimli tanımlamalar

        val aquamanDrawableId = R.drawable.aquaman
        val batmanDrawableId = R.drawable.batman
        val ironmanDrawableId = R.drawable.ironman
        val spidermanDrawableId = R.drawable.spiderman
        val supermanDrawableId = R.drawable.superman

        val superKahramanDrawableListesi = ArrayList<Int>()
        superKahramanDrawableListesi.add(aquamanDrawableId)
        superKahramanDrawableListesi.add(batmanDrawableId)
        superKahramanDrawableListesi.add(ironmanDrawableId)
        superKahramanDrawableListesi.add(spidermanDrawableId)
        superKahramanDrawableListesi.add(supermanDrawableId)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = RecyclerAdapter(superKahramanListesi, superKahramanDrawableListesi)
        recyclerView.adapter = adapter
    }
}