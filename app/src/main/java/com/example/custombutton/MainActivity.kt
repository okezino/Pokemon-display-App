package com.example.custombutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.custombutton.model.PokemonPojo

class MainActivity : AppCompatActivity() {
    lateinit var Viewmodel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        Viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        Viewmodel.cancelJob()
    }
}