package com.fidansoft.sqliteogrenmeprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val veritabani = this.openOrCreateDatabase("Urunler", MODE_PRIVATE, null)




            veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY, isim VARCHAR, fiyat INTEGER)")
            //Ekleme
//            veritabani.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('PALTO',250)")
//            veritabani.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('ELBİSE',50)")
//            veritabani.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('TİŞÖRT',20)")
//            veritabani.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('ATKI',10)")
//            veritabani.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('BERE',15)")

            //Silme
            //veritabani.execSQL("DELETE FROM urunler WHERE id = 5")

            //Güncelleme
            //veritabani.execSQL("UPDATE urunler SET fiyat = 250 WHERE isim='PANTOLON'")
            veritabani.execSQL("UPDATE urunler SET isim = 'Çakı' WHERE id = 1")

            val cursor = veritabani.rawQuery("SELECT * FROM urunler", null)
           // val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim='BERE'", null)
           // val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE id = 3", null)
           // val cursor = veritabani.rawQuery("SELECT * FROM urunler WHERE isim LIKE '%E'", null)

            val idColumnIndex = cursor.getColumnIndex("id")
            val isimColumnIndex = cursor.getColumnIndex("isim")
            val fiyatColumnIndex = cursor.getColumnIndex("fiyat")

            while (cursor.moveToNext()){
                println("ID: ${cursor.getInt(idColumnIndex)}")
                println("ISIM: ${cursor.getString(isimColumnIndex)}")
                println("FIYAT: ${cursor.getInt(fiyatColumnIndex)}")
            }
            cursor.close()

        } catch (e : Exception){
            e.printStackTrace()
        }
    }
}