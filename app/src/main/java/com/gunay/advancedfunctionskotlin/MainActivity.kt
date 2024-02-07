package com.gunay.advancedfunctionskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

//delegation - interfaceyi uygulayan bir sınıfı by anahtar kelimesi ile başka sınıflar içinde kullanma
class MainActivity : AppCompatActivity(), LifecycleLogger by LifeCycleLoggerImplementation() {

    private val myInt : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //property delegates
        val myVariable by lazy {
            println("hello this is a lazy implementation")
            10
        }


        //let
        //iki farklı yazım şekli
        if (myInt != null){
            val num = myInt + 1
        }
        //iki farklı yazım şekli
        myInt?.let {
            val num = myInt + 1

        }

        //?: 0 değeri olmasa ve işlem yapılmasa bile null bırakmaz değişkeni 0 yapar
        val myNum = myInt?.let {
            val num = myInt + 1
        } ?: 0


        //also  ---> şunuları yap üzerine bunu yap
        val gunay = Person("gunay",30)
        val giray = Person("giray",40)
        val gokay = Person("gokay",20)

        val people = listOf<Person>(gunay,giray,gokay)

        people.filter { it.age > 18 }.also {
            for(person in it ){
                println(person.name)
            }
        }


        //with and apply
        Person("barley",4).apply {
            name = "Barley"
        }.also {
            println(it.name)
        }


        val newBarley = Person("bar",4).apply {
            name = "Barley"
        }
        println(newBarley.name)

        val anotherBarley = with(Person("arley",4)){
            name = "Barley"
        }

        println(anotherBarley)

        val withBarley = Person("arely",4)
        with(withBarley) {
            name = "Barley"
            age = 4
        }
        println(withBarley.name)



    }
}

data class Person(var name: String, var age: Int)



interface LifecycleLogger {
    fun registerLifecycleOwner(owner: LifecycleOwner)
}

class LifeCycleLoggerImplementation : LifecycleLogger, LifecycleEventObserver {
    override fun registerLifecycleOwner(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_RESUME -> println("on resume executed")
            Lifecycle.Event.ON_PAUSE -> println("on pause executed")
            else -> Unit
        }
    }
}
















