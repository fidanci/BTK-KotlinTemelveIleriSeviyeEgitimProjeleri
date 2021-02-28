package com.fidansoft.yemektariflerisqlite

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_liste.*

class ListeFragment : Fragment() {

    var yemekIsmiListesi = ArrayList<String>()
    var yemekIdListesi = ArrayList<Int>()
    private lateinit var listAdapter : ListeRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = ListeRecyclerAdapter(yemekIsmiListesi, yemekIdListesi)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = listAdapter

        sqlVeriAlma()
    }

    fun sqlVeriAlma() {
        try {
            activity?.let {
                val database = it.openOrCreateDatabase("Yemekler", MODE_PRIVATE, null)
                val cursor = database.rawQuery("SELECT * FROM yemekler", null)
                val yemekidIndex = cursor.getColumnIndex("id")
                val yemekIsmiIndex = cursor.getColumnIndex("yemekismi")

                yemekIsmiListesi.clear()
                yemekIdListesi.clear()

                while (cursor.moveToNext()){
                    yemekIsmiListesi.add(cursor.getString(yemekIsmiIndex))
                    yemekIdListesi.add(cursor.getInt(yemekidIndex))
                }
                listAdapter.notifyDataSetChanged()

                cursor.close()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}