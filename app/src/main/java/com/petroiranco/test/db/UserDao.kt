package com.petroiranco.test.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(user: User)

    @Query("DELETE FROM USER_TABLE")
    suspend fun deleteAll()


    @Query("SELECT * from USER_TABLE")
    fun getAllQueues(): Flow<List<User>>
}