package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("relationships")
	val relationships: Relationships? = null,

	@field:SerializedName("links")
	val links: Links? = null,

	@field:SerializedName("attributes")
	val attributes: Attributes? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)