package com.example.workmanagerdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var button : Button
    private lateinit var textView: TextView

    companion object{
        const val KEY_COUNT_VALUE = "key_count"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        button.setOnClickListener {

            setOneTimeWorkRequest()
            //setPeriodicWorkRequest()
        }
    }


    private fun setOneTimeWorkRequest(){
        val workManager =WorkManager.getInstance(applicationContext)

        val data : Data = Data.Builder()
            .putInt(KEY_COUNT_VALUE,125)
            .build()
        val contraints = Constraints.Builder()
            .setRequiresCharging(false)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(contraints)
            .setInputData(data)
            .build()

        val fileringRequest = OneTimeWorkRequest.Builder(FilteringWorker::class.java)
                                .build()
        val compressingRequest = OneTimeWorkRequest.Builder(CompressingWorker::class.java)
                                  .build()
        val downloadRequest = OneTimeWorkRequest.Builder(DownloadingWorker::class.java)
                                   .build()
        val parallelWorks : MutableList<OneTimeWorkRequest> = mutableListOf()
        parallelWorks.add(downloadRequest)
        parallelWorks.add(fileringRequest)

        val uploadRequestWorkInfo =workManager.getWorkInfoByIdLiveData(uploadRequest.id)
        workManager.beginWith(parallelWorks)
            .then(compressingRequest)
            .then(uploadRequest)
            .enqueue()

            uploadRequestWorkInfo
            .observe(this, Observer {
                textView.text = it.state.name
                if(it.state.isFinished){
                    val data = it.outputData
                    val message = data.getString(UploadWorker.KEY_WORKER)
                    Toast.makeText(applicationContext ,message ,Toast.LENGTH_LONG).show()
                }
            })
//        workManager.cancelWorkById(uploadRequest.id)


    }

    private fun setPeriodicWorkRequest(){
        val periodicWorkRequest = PeriodicWorkRequest.Builder(DownloadingWorker::class.java,16,TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(periodicWorkRequest)
    }


}