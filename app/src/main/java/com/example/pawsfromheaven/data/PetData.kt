package com.example.pawsfromheaven.data

import com.example.pawsfromheaven.R

data class PetData(
    val id:Int,
    val name:String,
    val sex:String,
    val age:Int,
    val weight:Double,
    val ImagePath:Int
)

var PetList = mutableListOf<PetData>(
    PetData(0,"Sam","Male",2,4.0, R.drawable.cat1),
    PetData(1,"Matewis","Male",2,6.3, R.drawable.cat2),
    PetData(2,"Tinka","Female",2,4.7, R.drawable.cat3),
    PetData(3,"Milky","Female",2,4.0, R.drawable.cat4),
    PetData(4,"Garfield","Male",2,50.0, R.drawable.cat5),
    PetData(5,"Tom","Male",2,20.5, R.drawable.cat6),
)