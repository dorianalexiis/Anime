package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class Titles(

	@field:SerializedName("en")
	val en: String? = null,

	@field:SerializedName("ja_jp")
	val jaJp: String? = null,

	@field:SerializedName("en_jp")
	val enJp: String? = null
)