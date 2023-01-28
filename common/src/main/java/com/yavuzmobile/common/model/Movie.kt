package com.yavuzmobile.common.model

import com.google.gson.annotations.SerializedName
import com.yavuzmobile.common.BaseModel

data class Movie(
    var page: Int?,
    var results: List<MovieResult>?,
    var dates: MovieDate?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
): BaseModel()