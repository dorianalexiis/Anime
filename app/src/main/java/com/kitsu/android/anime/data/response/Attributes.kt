package com.kitsu.android.anime.data.response

import com.google.gson.annotations.SerializedName

data class Attributes(

	@field:SerializedName("nextRelease")
	val nextRelease: Any? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("episodeCount")
	val episodeCount: Int? = null,

	@field:SerializedName("ratingRank")
	val ratingRank: Int? = null,

	@field:SerializedName("posterImage")
	val posterImage: PosterImage? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("subtype")
	val subtype: String? = null,

	@field:SerializedName("youtubeVideoId")
	val youtubeVideoId: String? = null,

	@field:SerializedName("averageRating")
	val averageRating: String? = null,

	@field:SerializedName("coverImage")
	val coverImage: CoverImage? = null,

	@field:SerializedName("ratingFrequencies")
	val ratingFrequencies: RatingFrequencies? = null,

	@field:SerializedName("showType")
	val showType: String? = null,

	@field:SerializedName("abbreviatedTitles")
	val abbreviatedTitles: List<Any?>? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("episodeLength")
	val episodeLength: Int? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("nsfw")
	val nsfw: Boolean? = null,

	@field:SerializedName("synopsis")
	val synopsis: String? = null,

	@field:SerializedName("titles")
	val titles: Titles? = null,

	@field:SerializedName("ageRating")
	val ageRating: String? = null,

	@field:SerializedName("favoritesCount")
	val favoritesCount: Int? = null,

	@field:SerializedName("coverImageTopOffset")
	val coverImageTopOffset: Int? = null,

	@field:SerializedName("canonicalTitle")
	val canonicalTitle: String? = null,

	@field:SerializedName("tba")
	val tba: String? = null,

	@field:SerializedName("userCount")
	val userCount: Int? = null,

	@field:SerializedName("popularityRank")
	val popularityRank: Int? = null,

	@field:SerializedName("ageRatingGuide")
	val ageRatingGuide: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)