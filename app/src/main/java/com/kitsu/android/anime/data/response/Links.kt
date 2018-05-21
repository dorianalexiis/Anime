package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class Links(

	@field:SerializedName("related")
	val related: String? = null,

	@field:SerializedName("self")
	val self: String? = null,

	@field:SerializedName("last")
	val last: String? = null
)