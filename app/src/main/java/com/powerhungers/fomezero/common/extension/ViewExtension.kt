package com.powerhungers.fomezero.common.extension

import android.animation.ObjectAnimator
import android.widget.EditText
import android.widget.ProgressBar

private const val ANIMATION_DURATION = 2000L
private const val PROGRESS_BAR_PROPERTY_NAME = "progress"

fun ProgressBar.setAnimationDuration(progress: Int) {
    ObjectAnimator.ofInt(this, PROGRESS_BAR_PROPERTY_NAME, progress)
        .setDuration(ANIMATION_DURATION)
        .start()
}

fun EditText.hasEditTextFocusChanged(action: () -> Unit) {
    this.setOnFocusChangeListener { _, hasFocus ->
        if (hasFocus) {
            action()
        }
    }
}