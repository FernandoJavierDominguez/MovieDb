package com.fernandodominguezpacheco.moviedb.framework.server

import com.google.gson.annotations.SerializedName

data class Actor (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("profile_path") val profile_path: String?,
    @SerializedName("character") val character: String
)