package com.konaire.numerickeyboard.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView

@SuppressLint("AppCompatCustomView")
internal class IconifiedTextView : TextView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
        setIconifiedTypeface()
    }

    private fun setIconifiedTypeface() {
        typeface = Typeface.createFromAsset(context.assets, "fonts/material_icons.ttf")
    }
}
