package com.powerhungers.fomezero.common.extension

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment

fun Fragment.openExternalUrl(url: String) {
    startActivity(
        Intent(Intent.ACTION_VIEW).setData(Uri.parse(url))
    )
}