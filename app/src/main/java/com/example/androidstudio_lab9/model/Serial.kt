package com.example.androidstudio_lab9.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Serial (
    @StringRes val titleResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @DrawableRes val imageResourceId: Int
)