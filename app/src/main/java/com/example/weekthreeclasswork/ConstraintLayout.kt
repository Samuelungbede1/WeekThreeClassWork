package com.example.weekthreeclasswork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class ConstraintLayout : AppCompatActivity() {

    var fragManager= supportFragmentManager

    var welcomeFragment= welcomeFragment()
    var searchFragment= searchFragment()

    var count = 0
    var isChecked= true


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
        outState.putBoolean("isChecked", isChecked )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button_one)
        var buttonTwo = findViewById<Switch>(R.id.button_two)
        var buttonThree = findViewById<Button>(R.id.button_three)
        var textCount = findViewById<TextView>(R.id.text_count)
        var homeButton = findViewById<Button>(R.id.home_btn)
        var searchButton = findViewById<Button>(R.id.search_btn)


        homeButton.setOnClickListener {
            var transaction= fragManager.beginTransaction()
            transaction.replace(R.id.relative,welcomeFragment)
                .commit()

        }


        searchButton.setOnClickListener {
            var transaction= fragManager.beginTransaction()
            transaction.replace(R.id.relative,searchFragment)
                .commit()
        }

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count")
            textCount.text=count.toString()
            isChecked= savedInstanceState.getBoolean("isChecked")
            if (isChecked) {
                button.isEnabled = true
                buttonTwo.text = "disable"
                isChecked=false
            } else {
                button.isEnabled = false
                buttonTwo.text = "enable"
                isChecked=true
            }
        }

        button.setOnClickListener {}


        buttonTwo.setOnClickListener {
            if (isChecked) {
                button.isEnabled = true
                buttonTwo.text = "disable"
                isChecked=false

            } else {
                button.isEnabled = false
                buttonTwo.text = "enable"
                isChecked=true

            }
        }

        buttonThree.setOnClickListener {
            count++
            textCount.text = count.toString()
        }

        }
}

