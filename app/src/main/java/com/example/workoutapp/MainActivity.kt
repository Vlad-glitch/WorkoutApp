package com.example.workoutapp

import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.telecom.Call
import android.util.Log
import android.view.Window
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.drawToBitmap
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ActivityMainBinding
import com.example.workoutapp.network.ApiClient
import com.example.workoutapp.network.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import javax.security.auth.callback.Callback
import javax.security.auth.callback.CallbackHandler

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private var addedExercise : Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        addedExercise = false

        binding?.flStart?.setOnClickListener{
            val intent = Intent(this , ExerciseActivity::class.java)
            intent.putExtra(Constants.addedExercise, addedExercise)
            startActivity(intent)
        }

        binding?.flBMI?.setOnClickListener{
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        binding?.flHistory?.setOnClickListener{
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }


        binding?.ibDownload?.setOnClickListener {
            Toast.makeText(this, "Adding new exercise", Toast.LENGTH_SHORT).show()
            /*lifecycleScope.launch {
                        save(binding?.ibDownload!!.drawToBitmap())
            }
            */

            addedExercise = true

        }

    }

    private suspend fun save(mBitmap: Bitmap): String{
        var result = ""
        withContext(Dispatchers.IO){
            if(mBitmap != null){
                try{
                    val bytes = ByteArrayOutputStream()
                    mBitmap.compress(Bitmap.CompressFormat.PNG, 90, bytes)

                    val f = File(externalCacheDir?.absoluteFile.toString()
                            + File.separator + "Workout" + System.currentTimeMillis()
                            / 1000 + ".png")
                    val fo = FileOutputStream(f)
                    fo.write(bytes.toByteArray())
                    fo.close()

                    result = f.absolutePath

                    runOnUiThread{
                        if(result.isNotEmpty()){
                            Toast.makeText(this@MainActivity, "Saved : $result", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()

                        }
                    }

                }
                catch (e: Exception){
                    result = ""
                    e.printStackTrace()
                }
            }
        }
        return result
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}