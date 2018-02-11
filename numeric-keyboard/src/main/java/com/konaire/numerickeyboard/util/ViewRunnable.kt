package com.konaire.numerickeyboard.util

import android.view.View

/**
 * Created by Evgeny Eliseyev on 11/02/2018.
 */

internal abstract class ViewRunnable: Runnable {
    protected var view: View? = null

    fun setView(view: View?): ViewRunnable {
        this.view = view
        return this
    }
}