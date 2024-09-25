package ir.androidcoder.testingandroid.data.remote.responses

import com.google.gson.annotations.SerializedName

data class ImageResult(

    val comments : Int,
    val download : Int,
    val favorites : Int,
    val id : String,
    val imageHeight : Int,
    val imageSize : Int,
    val imageWidth : Int,
    val largeImage : String,
    val likes : Int,
    val pageURL : String,
    val previewHeight : Int,
    val previewURL : String,
    val previewWidth: Int,
    val tags: String,
    val type : String,
    val user : String,
    @SerializedName("user_id")
    val userId : Int,
    val userImageURL : String,
    val views : Int,
    val webformatHeight : Int,
    val webformatURL : String,
    val webformatWidth : Int
)
