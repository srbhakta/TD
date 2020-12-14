package com.example.td.remote
/*
    Data class models for holding json data fetched by Retrofit.
 */
data class HomePageData(val page: Page)
data class Page(val cards: List<CardDetail>)

data class CardDetail(val card_type: String, val card: Card)
data class Card(val value: String?,
            val attributes: Attributes?,
            val title: Title?,
            val description: Description?,
            val image: Image?)


data class Title(val value: String, val attributes: Attributes)
data class Description(val value: String, val attributes: Attributes)

data class Attributes(val text_color: String, val font: Font)
data class Font(val size: Int)

data class Image(val url: String, val size: Size)
data class Size(val width: Int, val height: Int)
