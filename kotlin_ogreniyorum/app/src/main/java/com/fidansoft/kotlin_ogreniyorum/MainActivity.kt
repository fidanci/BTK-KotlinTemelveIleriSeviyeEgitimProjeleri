package com.fidansoft.kotlin_ogreniyorum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Merhaba kotlin")

        val superman = Superkahraman("superman",15,"torbacı")
        println("İsim: ${superman.getIsim()}, Yas: ${superman.getYas()}, Meslek: ${superman.getMeslek()}")
        superman.testFun(superman.getIsim())

        nullGuvenligi()
    }

    private fun nullGuvenligi(){
        //Null, Nullability, null Safety

        var myInt : Int? = null
        println(myInt)

        // 1
        if(myInt != null){
            println(myInt * 2)
        } else{
            println("null geldi")
        }

        //2
        println(myInt?.minus(2))

        //3 Elvis operatörü
        val sonuc = myInt?.minus(2) ?: 10
        println(sonuc)

        //4 let
        myInt = 5
        myInt?.let {
            println(it * 5)
        }
    }
}