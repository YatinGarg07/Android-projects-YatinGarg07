package com.anushka.asyncawaitdemo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager1 {

    suspend fun getTotalUserCount():Int {
        var count = 0 ;
        CoroutineScope(IO).launch{
        delay(1000)
            count = 50
        }
        return count

    }

}