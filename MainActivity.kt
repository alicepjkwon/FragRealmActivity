package com.example.fragmentrealmactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this)

        btm_to_frag.setOnClickListener {
            setContentView(R.layout.insert_container)
            val bt = supportFragmentManager.beginTransaction()
            bt.add(R.id.container, InsertFrag())
            bt.addToBackStack(null)
            bt.commit()
        }

        Log.e("FragLifeCycle", "onCreate()")
    }


    override fun onRestart() {
        super.onRestart()
        Log.e("FragLifeCycle", "onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.e("FragLifeCycle", "onStart()")
        }

    override fun onResume() {
        super.onResume()

        Log.e("FragLifeCycle", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("FragLifeCycle", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("FragLifeCycle", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("FragLifeCycle", "onDestroy()")
    }


}

