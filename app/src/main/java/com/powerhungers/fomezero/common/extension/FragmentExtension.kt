package com.powerhungers.fomezero.common.extension

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

fun Fragment.openExternalUrl(url: String) {
    startActivity(
        Intent(Intent.ACTION_VIEW).setData(Uri.parse(url))
    )
}

fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}

fun Fragment.showToast(message:Int){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

