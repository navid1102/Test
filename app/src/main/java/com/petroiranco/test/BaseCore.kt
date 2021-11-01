package com.petroiranco.test

import android.content.res.Resources
import org.koin.core.KoinComponent
import org.koin.core.inject

object BaseCore : KoinComponent {
    val ms: MyShared by inject()
    val res: Resources by inject()
}