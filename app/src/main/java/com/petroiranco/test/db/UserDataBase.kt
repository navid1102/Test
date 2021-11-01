package com.petroiranco.test.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version =9,exportSchema = false)
abstract class UserDataBase:RoomDatabase(){

    abstract fun queueDao():UserDao



    companion object {

        @Volatile private var INSTANCE: UserDataBase? = null

        fun getDatabase(context: Context): UserDataBase =
            INSTANCE ?: synchronized(this) { INSTANCE ?: buildDatabase(context).also { INSTANCE = it } }

        private fun buildDatabase(ctx: Context) =
            Room.databaseBuilder(ctx.applicationContext, UserDataBase::class.java, "ITMS_database")
                .fallbackToDestructiveMigration()
                .build()
    }

}
