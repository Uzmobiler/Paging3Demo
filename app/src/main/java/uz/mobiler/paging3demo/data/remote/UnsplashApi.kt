package uz.mobiler.paging3demo.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import uz.mobiler.paging3demo.BuildConfig
import uz.mobiler.paging3demo.models.SearchResult
import uz.mobiler.paging3demo.models.UnsplashImage

interface UnsplashApi {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): List<UnsplashImage>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("per_page") per_page: Int
    ): SearchResult

}