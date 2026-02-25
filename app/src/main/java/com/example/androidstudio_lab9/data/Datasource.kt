package com.example.androidstudio_lab9.data

import com.example.androidstudio_lab9.R
import com.example.androidstudio_lab9.model.Serial

class Datasource {
    fun loadSerialList(): List<Serial> {
        return listOf(
            Serial (
                titleResourceId = R.string.item1,
                descriptionResourceId = R.string.item1_description,
                imageResourceId = R.drawable.item1
            ),
            Serial (
                titleResourceId = R.string.item2,
                descriptionResourceId = R.string.item2_description,
                imageResourceId = R.drawable.item2),
            Serial (
                titleResourceId = R.string.item3,
                descriptionResourceId = R.string.item3_description,
                imageResourceId = R.drawable.item3),
        )
    }
}