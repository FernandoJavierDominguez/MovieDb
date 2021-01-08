package com.fernandodominguezpacheco.moviedb.framework.server

import com.google.gson.annotations.SerializedName

data class Cast (
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val list: List<Actor>
    )
