package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class MediaRelationships(

	@field:SerializedName("links")
	val links: Links? = null
)