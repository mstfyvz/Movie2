package com.yavuzmobile.common.model

import com.google.gson.annotations.SerializedName
import com.yavuzmobile.common.BaseModel

data class MovieDetail(
    var adult: Boolean?,
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    var budget: Int,
    var id: Int?,
    @SerializedName("imdb_id")
    var imdbId: String?,
    @SerializedName("original_title")
    var originalTitle: String?,
    var overview: String?,
    var popularity: Double?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    var status: String?,
    var title: String?,
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @SerializedName("vote_count")
    var voteCount: Int?
): BaseModel()
