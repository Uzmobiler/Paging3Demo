package uz.mobiler.paging3demo.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.mobiler.paging3demo.data.local.UnsplashDatabase
import uz.mobiler.paging3demo.utils.Constants.UNSPLASH_DATABASE
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UnsplashDatabase {
        return Room.databaseBuilder(context,UnsplashDatabase::class.java,UNSPLASH_DATABASE).build()
    }
}