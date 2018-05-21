package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class Relationships(

	@field:SerializedName("castings")
	val castings: Castings? = null,

	@field:SerializedName("mappings")
	val mappings: Mappings? = null,

	@field:SerializedName("animeStaff")
	val animeStaff: AnimeStaff? = null,

	@field:SerializedName("reviews")
	val reviews: Reviews? = null,

	@field:SerializedName("installments")
	val installments: Installments? = null,

	@field:SerializedName("genres")
	val genres: Genres? = null,

	@field:SerializedName("animeCharacters")
	val animeCharacters: AnimeCharacters? = null,

	@field:SerializedName("mediaRelationships")
	val mediaRelationships: MediaRelationships? = null,

	@field:SerializedName("animeProductions")
	val animeProductions: AnimeProductions? = null,

	@field:SerializedName("categories")
	val categories: Categories? = null,

	@field:SerializedName("streamingLinks")
	val streamingLinks: StreamingLinks? = null,

	@field:SerializedName("episodes")
	val episodes: Episodes? = null
)