package com.technipixl.testexo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView

import com.technipixl.testexo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnNouveau?.setOnClickListener {
            navigateToAddArticle()
        }
    }
     private fun navigateToAddArticle() {
         findNavController(R.id.containerView).navigate(R.id.action_fragmentShoppingList_to_fragmentAddArticle)
     }
}