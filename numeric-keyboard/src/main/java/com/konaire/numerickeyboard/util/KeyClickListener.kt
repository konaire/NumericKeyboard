package com.konaire.numerickeyboard.util

import android.annotation.SuppressLint
import android.view.View
import android.widget.EditText
import android.widget.TextView

import com.konaire.numerickeyboard.IconifiedTextView

/**
 * Created by Evgeny Eliseyev on 11/02/2018.
 */

internal class KeyClickListener(
    private val maxLength: Int,
    private val field: EditText?
): View.OnClickListener {
    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        val field = this.field ?: return

        if (view is IconifiedTextView) {
            val lastChar = field.text.length - 1

            if (lastChar >= 0) {
                val value = field.text.toString().substring(0, lastChar)

                field.setText(value)
                field.setSelection(lastChar)
            }
        } else if (view is TextView) {
            if (maxLength > 0 && field.text.length == maxLength) {
                return
            }

            val builder = StringBuilder(field.text)

            builder.append(view.text)
            field.setText(builder.toString())
            field.setSelection(field.text.length)
        }
    }
}