package uz.mobiler.paging3demo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.mobiler.paging3demo.data.local.dao.UnsplashImageDao
import uz.mobiler.paging3demo.data.local.dao.UnsplashRemoteKeysDao
import uz.mobiler.paging3demo.models.UnsplashImage
import uz.mobiler.paging3demo.models.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}