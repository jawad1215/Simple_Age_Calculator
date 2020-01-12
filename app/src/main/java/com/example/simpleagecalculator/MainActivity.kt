package com.example.simpleagecalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.simpleagecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var ageData: AgeData = AgeData("Age Calculator")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.ageData = ageData
        binding.button.setOnClickListener { calculateAge(it) }


    }

    private fun calculateAge(view: View) {
        binding.apply {

            val ageStr: String = ageEditText.text.toString()
            val finalAge: Int
            val age = ageStr.toInt()

            if (age in 1..2020) {

                finalAge = 2020 - age
                displayText.text = finalAge.toString()

            } else {

                displayText.text = "Wrong Input"
            }

            ageEditText.visibility = View.GONE
            button.visibility = View.GONE
            displayText.visibility = View.VISIBLE
            ageTitleId.text = "Your Age is"

        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
