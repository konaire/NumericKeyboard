package com.konaire.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Evgeny Eliseyev on 10/02/2018.
 */

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add decimal separator
        //keyboard.keySpecialText = "."

        /*
            // Example code to customize special button behaviour
            keyboard.keySpecialText = "TOAST"
            keyboard.onKeySpecialClick {
                Toast.makeText(this, "Special key pressed!", Toast.LENGTH_SHORT).show()
            }
        */
    }
}
