package com.sahin.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sahin.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var shared : SharedPreferences
    var myAge : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Küçük verileri saklamak veya depolamak için sharedpreferences kullanırız.
        shared = this.getSharedPreferences("com.sahin.storingdata",Context.MODE_PRIVATE)

        myAge = shared.getInt("myAge",0)
        if(myAge != 0){
            binding.ageTextview.text = "Your Age :${myAge}"
        }else{
            binding.ageTextview.text = "Your Age : "
        }

    }
    fun save(view : View){
        var age = binding.ageText.text.toString().toIntOrNull()
        if(age != null){
            shared.edit().putInt("myAge",age).apply()
            binding.ageTextview.text = "Your Age :${age}"
        }else{
            binding.ageTextview.text = "Please,Enter correctly"
        }

    }
    fun delete(view : View){
        myAge = shared.getInt("myAge",0)
        if(myAge != 0){
            shared.edit().remove("myAge").apply()
            binding.ageTextview.text = "Your Age : "
        }

    }
}