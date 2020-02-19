package com.example.dicodingmovie2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var title: String,
    var description: String,
    var poster: Int,
    var releaseDate: String,
    var durationTime: String,
    var distributedBy: String
):Parcelable