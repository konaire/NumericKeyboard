package com.konaire.numerickeyboard.util

import android.os.Build
import android.widget.EditText

/**
 * Created by Evgeny Eliseyev on 11/02/2018.
 */

fun EditText.suppressSoftKeyboard() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        showSoftInputOnFocus = false
    } else {
        try {
            val method = EditText::class.java.getMethod("setShowSoftInputOnFocus", Boolean::class.java)
            method.isAccessible = true
            method.invoke(this, false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}