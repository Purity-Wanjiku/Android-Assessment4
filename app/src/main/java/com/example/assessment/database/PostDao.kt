package com.example.assessment.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.assessment.models.PostEntity
import retrofit2.http.Query

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostEntity>)
    @Query("SELECT * FROM posts")
    fun getAllPosts(): LiveData<List<PostEntity>>

}
