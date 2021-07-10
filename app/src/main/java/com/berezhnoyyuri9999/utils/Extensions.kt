package com.berezhnoyyuri9999.utils

import android.content.Context
import com.berezhnoyyuri9999.AppApplication
import com.berezhnoyyuri9999.AppComponent

val Context.appComponent : AppComponent
    get() = when(this) {
        is AppApplication -> appComponent
        else -> applicationContext.appComponent
    }