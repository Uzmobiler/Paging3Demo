package uz.mobiler.paging3demo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.mobiler.paging3demo.models.UnsplashRemoteKeys

@Dao
interface UnsplashRemoteKeysDao {

    @Query("select * from unsplash_remote_keys_table where id=:id")
    suspend fun getRemoteKeys(id: String): UnsplashRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<UnsplashRemoteKeys>)

    @Query("delete from unsplash_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}