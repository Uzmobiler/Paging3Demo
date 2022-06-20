package uz.mobiler.paging3demo.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.mobiler.paging3demo.utils.Constants.UNSPLASH_REMOTE_KEYS_TABLE

@Entity(tableName = UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)