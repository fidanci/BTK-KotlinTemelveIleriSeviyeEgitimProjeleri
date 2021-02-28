package com.fidansoft.kotlin_ogreniyorum

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_super_kahraman_aktivity.*

class SuperKahramanAktivity : AppCompatActivity() {
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_kahraman_aktivity)
    }

    fun superKahramanEkle(view: View) {
        val isim = isimText.text.toString()
        val yas = yasText.text.toString().toIntOrNull()
        val meslek = meslekText.text.toString()

        if (yas == null) {
            sonucTextView.text = "Yaşı doğru giriniz"
        } else {
            val superkahraman = Superkahraman(isim, yas, meslek)

            sonucTextView.text =
                "Isim: ${superkahraman.getIsim()}, Yas: ${superkahraman.getYas()}, Meslek: ${superkahraman.getMeslek()} "
        }

    }
}