package com.konaire.numerickeyboard

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

import com.konaire.numerickeyboard.util.suppressSoftKeyboard

/**
 * Created by Evgeny Eliseyev on 10/02/2018.
 */

class NumericKeyboard: FrameLayout, View.OnClickListener {
    private abstract class ViewRunnable: Runnable {
        protected var view: View? = null

        fun setView(view: View?): ViewRunnable {
            this.view = view
            return this
        }
    }

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    private val removeChar: ViewRunnable = object: ViewRunnable() {
        override fun run() {
            onClick(view)
            handler.postDelayed(this, 50)
        }
    }

    var maxLength: Int = 0
    var field: EditText? = null
        set(value) {
            field = value
            field?.suppressSoftKeyboard()
        }

    override fun onFinishInflate() {
        super.onFinishInflate()
        init()
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        val field = this.field ?: return

        if (view is TextView) {
            if (maxLength > 0 && field.text.length == maxLength) {
                return
            }

            val builder = StringBuilder(field.text)

            builder.append(view.text)
            field.setText(builder.toString())
            field.setSelection(field.text.length)
        } else if (view is ImageView) {
            val lastChar = field.text.length - 1
            if (lastChar >= 0) {
                val value = field.text.toString().substring(0, lastChar)

                field.setText(value)
                field.setSelection(lastChar)
            }
        }
    }

    private fun init() {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.widget_keyboard, this, false)

        layout.findViewById<View>(R.id.key1).setOnClickListener(this)
        layout.findViewById<View>(R.id.key2).setOnClickListener(this)
        layout.findViewById<View>(R.id.key3).setOnClickListener(this)
        layout.findViewById<View>(R.id.key4).setOnClickListener(this)
        layout.findViewById<View>(R.id.key5).setOnClickListener(this)
        layout.findViewById<View>(R.id.key6).setOnClickListener(this)
        layout.findViewById<View>(R.id.key7).setOnClickListener(this)
        layout.findViewById<View>(R.id.key8).setOnClickListener(this)
        layout.findViewById<View>(R.id.key9).setOnClickListener(this)
        layout.findViewById<View>(R.id.key0).setOnClickListener(this)

        layout.findViewById<View>(R.id.keyRemove).setOnClickListener(this)
        layout.findViewById<View>(R.id.keyRemove).setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> handler.postDelayed(removeChar.setView(view), 750)
                MotionEvent.ACTION_UP -> handler.removeCallbacks(removeChar)
            }

            false
        }

        addView(layout)
    }
}