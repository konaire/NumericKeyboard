package com.konaire.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Evgeny Eliseyev on 10/02/2018.
 */

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        keyboard.field = field
        keyboard.maxLength = 10
    }
}