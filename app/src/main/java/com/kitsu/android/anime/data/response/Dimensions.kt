package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class Dimensions(

	@field:SerializedName("small")
	val small: Small? = null,

	@field:SerializedName("large")
	val large: Large? = null,

	@field:SerializedName("tiny")
	val tiny: Tiny? = null,

	@field:SerializedName("medium")
	val medium: Medium? = null
)