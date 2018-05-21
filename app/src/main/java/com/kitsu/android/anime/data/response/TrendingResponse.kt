package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class TrendingResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)