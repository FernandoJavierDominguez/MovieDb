package com.fernandodominguezpacheco.moviedb.framework.server

import com.google.gson.annotations.SerializedName

data class Actor (
    @SerializedName("id") val id: Int,
)