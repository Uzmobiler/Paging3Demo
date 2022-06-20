package uz.mobiler.paging3demo.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.mobiler.paging3demo.data.local.UnsplashDatabase
import uz.mobiler.paging3demo.data.paging.SearchPagingSource
import uz.mobiler.paging3demo.data.paging.UnsplashRemoteMediator
import uz.mobiler.paging3demo.data.remote.UnsplashApi
import uz.mobiler.paging3demo.models.UnsplashImage
import uz.mobiler.paging3demo.utils.Constants.ITEMS_PER_PAGE
import javax.inject.Inject

class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {

    @OptIn(ExperimentalPagingApi::class)
    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun searchImages(query:String): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(
                    unsplashApi = unsplashApi,
                    query = query
                )
            }
        ).flow
    }
}