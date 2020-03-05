package com.example.fragmentrealmactivity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*
//e: error: Class "Spending" must declare a public constructor with no arguments if it contains custom constructors.
open class Spending() : RealmObject() {
    @PrimaryKey var id : Long = -1L
    var date: String? = null
    var item:String? = ""
    var price:Int? = 0
    var buyAt:String? = ""
}