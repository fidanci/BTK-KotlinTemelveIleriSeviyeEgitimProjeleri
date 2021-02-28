package com.fidansoft.superkahramankitabi

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tanitim.*

class TanitimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanitim)

        val intent = intent
        val gelenkahramanismi = intent.getStringExtra("kahramanIsmi")
        val gelenkahramangorseli = intent.getIntExtra("kahramanGorseli",0)
        textView.text = gelenkahramanismi.toString()
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,gelenkahramangorseli)
        imageView.setImageBitmap(bitmap)

//        val secilenKahraman = SingletonClass.SecilenKahraman
//        val secilenGorsel = secilenKahraman.gorsel
//        imageView.setImageBitmap(secilenGorsel)
    }
}