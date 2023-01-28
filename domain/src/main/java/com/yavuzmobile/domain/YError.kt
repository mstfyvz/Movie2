package com.yavuzmobile.domain

import androidx.annotation.StringRes


sealed class YError {
    object Network : YError()
    object Timeout : YError()
    object Generic : YError()
    class Business(val msg: String, code: Int = 0) : YError()
    class StringResError(@StringRes val msgRes: Int) : YError()
}