package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class Meta(

	@field:SerializedName("dimensions")
	val dimensions: Dimensions? = null
)