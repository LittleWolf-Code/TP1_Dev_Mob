package com.example.tp1_dev_mob

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking


suspend fun main1(){
    runBlocking {
        val res = mainflow().map { it*3 } // res est un Flow
        //val res = mainflow().filter{ (it % 2) == 0 }
        println(res.fold(0){ acc, value -> acc+value })
        res.collect( // on collecte ses données
            {
                println(it)
            })
    }

}
fun mainflow() : Flow<Int> {
    return flow {
        emit(1)
        delay(200L)
        emit(2)
        delay(200L)
        emit(3)
        delay(200L)
    }
}

suspend fun main2(){
    runBlocking {
        val flow1= flowOf(1,2,3).onEach { delay(300) }
        val flow2= flowOf("a","b","c").onEach { delay(200) }
        flow1.zip(flow2){ i,s -> Pair(s,i)}.collect( // on collecte ses données
            {
                println(it)
            })
        flow1.combine(flow2) { i, s -> i.toString() + s }.collect {
            println(it) // Will print "1a 2a 2b 2c"
        }

    }

}

//debit et buffering

suspend fun main3(){
    runBlocking {
        val flow1= flowOf(1,2,3,4,5,6,7,8,9,10).onEach { println("Emission de "+it);delay(200) }
        println("Retardement de l'emetteur")
        flow1.collect({
            println(it)
            delay(500)
        })
        println("take3")
        flow1.take(3).collect({
            println(it)
            delay(500)
        })
        println("test avec buffer")
        flow1.buffer(3).collect({
            println(it)
            delay(500)
        })
        println("test avec conflate")
        flow1.conflate().collect({
            println(it)
            delay(500)
        })


    }

}

//concaténation de flow
suspend fun main(){
    runBlocking {
        val flow1= flowOf(1,2,3).onEach {delay(200) }
        val flow2= flowOf(4,5,6).onEach {delay(200) }
        flow1.onCompletion {emitAll(flow2) }.collect({print(" "+ it )})
        flow1.flatMapConcat { flowOf(flow2) }.collect({println(it)})




    }

}