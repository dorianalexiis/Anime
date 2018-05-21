package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class CoverImage(

	@field:SerializedName("small")
	val small: String? = null,

	@field:SerializedName("original")
	val original: String? = null,

	@field:SerializedName("large")
	val large: String? = null,

	@field:SerializedName("tiny")
	val tiny: String? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)