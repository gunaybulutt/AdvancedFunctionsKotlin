package com.gunay.advancedfunctionskotlin

fun main(){

    val myNumlist = listOf<Int>(1,3,5,7,9,11,13,15)


    println("filter")

    //filter
    //aynı kodun 3 farklı yazımı lambda ile (6'dan kuçük sayıları almak için kullanılır)
    //val smallNumberList = myNumlist.filter {num -> num < 6}
    //val smallNumberList = myNumlist.filter {it -> it < 6}
    val smallNumberList = myNumlist.filter {it < 6}

    for (num in smallNumberList){
        println(num)
    }


    println("map")

    //map
    //değerleri transform etmek başka bir hale çevirmek için kullanılır
    //listedeki bütün değerlerin karesini alır
    //val squaredNumbers = myNumlist.map { num -> num * num }
    val squaredNumbers = myNumlist.map { it * it}

    for (num in squaredNumbers){
        println(num)
    }


    println("filter and map")

    //filter and map
    //ikisinin beraber kullanımı
    //myNumlist içinden 6 dan küçük olan elemanlar alınır ve sonra bu elemanların karesi alınır (listedeki 6'dan küçük sayıların karesini alır)
    val filterAndMap = myNumlist.filter{it<6}.map { it * it }

    for (num in filterAndMap){
        println(num)
    }


    println("how to use this functions for class")

    val musicians = listOf<Musician>(
        Musician("James",60,"Guitar"),
        Musician("Lars",55,"Drum"),
        Musician("Kirk",50,"Guitar"),
        )

    val filteredMusician = musicians.filter { it.age < 60 }.map { it.instrument }
    for (num in filteredMusician){
        println(num)
    }
}



data class Musician(val name: String, val age: Int, val instrument: String)

















