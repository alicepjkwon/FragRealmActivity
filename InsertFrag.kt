package com.example.fragmentrealmactivity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.input_fragment.*
import java.util.*

class InsertFrag :Fragment(){
    val calendar:Calendar = Calendar.getInstance(Locale.KOREA)
    val realm = Realm.getDefaultInstance()


    private fun insertSpending(){
        realm.beginTransaction()
        val newInsert = realm.createObject<Spending>(nextId())
        newInsert.item = insert_item.text.toString()
        newInsert.price = insert_price.text.toString().toInt()
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.e("FragLifeCycle", "onAttach()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.input_fragment,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("FragLifeCycle", "onCreate() in fragment")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("FragLifeCycle", "onActivityCreated() in fragment")
    }

    override fun onPause() {
        super.onPause()
        Log.e("FragLifeCycle", "onPause() in fragment")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("FragLifeCycle", "onViewCreated() in fragment")
    }

    override fun onResume() {
        super.onResume()
        Log.e("FragLifeCycle", "onResume() in fragment")
    }

    override fun onStart() {
        super.onStart()
        Log.e("FragLifeCycle", "onStart() in fragment")
    }

    override fun onStop() {
        super.onStop()
        Log.e("FragLifeCycle", "onStop() in fragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
        Log.e("FragLifeCycle", "onDestroy() in fragment")
        }

    override fun onDetach() {
        super.onDetach()
        Log.e("FragLifeCycle", "onDestroy() in fragment")
    }
    private fun nextId():Int{
        val maxId = realm.where<Spending>().max("id")
        if(maxId!=null){
            return maxId.toInt() + 1
        }
        return 0
    }

}

