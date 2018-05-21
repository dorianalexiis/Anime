package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class Tiny(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("height")
	val height: Int? = null
)