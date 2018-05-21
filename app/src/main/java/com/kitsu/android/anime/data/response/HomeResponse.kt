package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName


data class HomeResponse(

	@field:SerializedName("data")
	val data: MutableList<DataItem?>? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("links")
	val links: Links? = null
)