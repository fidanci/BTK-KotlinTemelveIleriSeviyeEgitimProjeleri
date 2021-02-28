package com.fidansoft.kotlin_ogreniyorum

class Superkahraman(private var isim: String, private var yas: Int, private var meslek: String) {
    fun testFun(superkahramanadi: String) {
        println("Test fun $superkahramanadi")
    }

    fun getIsim(): String {
        return this.isim
    }

    fun getYas(): Int {
        return this.yas
    }

    fun getMeslek(): String {
        return this.meslek
    }
}