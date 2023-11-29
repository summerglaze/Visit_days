package com.example.a30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OneDay(
    @StringRes val dayResId: Int,
    val dayNr: Int,
    @StringRes val cityTopicId: Int,
    @DrawableRes val imageResId: Int,
    @StringRes val descriptionResId: Int
)
