package ir.androidcoder.testingandroid.data.remote

import ir.androidcoder.testingandroid.data.remote.responses.ImageResponse
import ir.androidcoder.testingandroid.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = API_KEY
    ) : Response<ImageResponse>

}