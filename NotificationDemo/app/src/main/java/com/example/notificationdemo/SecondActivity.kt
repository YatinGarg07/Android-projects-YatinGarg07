package com.example.notificationdemo

import android.app.Notification
import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat

class SecondActivity : AppCompatActivity() {
    private val KEY_REPLY = "key_reply"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        receiveInput()
    }

    private fun receiveInput(){
        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if(remoteInput!=null){
            val inputString = remoteInput.getCharSequence(KEY_REPLY).toString()
            val resultTextView : TextView = findViewById(R.id.result_text_view)
            resultTextView.text = inputString

            val channe1Id = "com.example.notificationdemo.channel1"
            val notificationId = 45

            val repliedNotification = NotificationCompat.Builder(this,channe1Id)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("Your reply recieved")
                .build()
            val notificationManager : NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(notificationId,repliedNotification)


        }
    }
}