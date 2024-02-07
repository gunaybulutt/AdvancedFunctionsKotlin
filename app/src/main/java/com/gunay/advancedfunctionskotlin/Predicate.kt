package com.gunay.advancedfunctionskotlin

fun main(){

    val myNumlist = listOf<Int>(1,3,5,7,9,11,13,15)

    //bu listedeki elemanların hepsi 5'ten büyük mü diye sorguluyor sonucu true yada false döndürüyor
    val allCheck = myNumlist.all { it > 5 }
    println(allCheck)


    // buradada herhangibiri 5 ten büyükse true yada false döndürür
    val anyCheck = myNumlist.any {it > 5}
    println(anyCheck)

    //5'ten büyük kaç adet eleman var
    val totalCount = myNumlist.count{it > 5}
    println(totalCount)


    //listedeki 5'ten büyük ilk elemanı getirir
    val findNum = myNumlist.find { it > 5 }
    println(findNum)

    //listedeki 5'ten büyük son elemanı bulur
    val findLast = myNumlist.findLast { it > 5 }
    println(findLast)


    //sürekli süslü parantez içine aynı koşulu yazmaktansa bir değişkenin içine koyup heryerde kullanılabilir
    val myPredicate = {num: Int -> num > 5}
    val allCheckWithPredicate = myNumlist.all(myPredicate)
    println(allCheckWithPredicate)


}