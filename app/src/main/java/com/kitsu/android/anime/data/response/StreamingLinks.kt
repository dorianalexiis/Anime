package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class StreamingLinks(

	@field:SerializedName("links")
	val links: Links? = null
)