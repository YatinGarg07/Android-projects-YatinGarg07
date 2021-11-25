package com.anushka.coroutinesdemo1

import kotlinx.coroutines.*

class UserDataManger2() {
    var count =0
    suspend fun getTotalUserCount() : Int{
        lateinit var deffered : Deferred<Int>
        coroutineScope {
        launch(Dispatchers.IO) {
            delay(1000)
            count = 50
        }

            deffered = async(Dispatchers.IO) {
                delay(3000)
                return@async 70
            }

        }
        return count + deffered.await()
    }
}