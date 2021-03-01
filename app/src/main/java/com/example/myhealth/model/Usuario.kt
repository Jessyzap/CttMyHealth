package com.example.myhealth.model

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Usuario(val nome: String,
                   var foto: Bitmap? = null) : Parcelable