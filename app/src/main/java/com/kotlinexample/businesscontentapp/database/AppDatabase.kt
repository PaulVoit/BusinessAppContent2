package com.kotlinexample.businesscontentapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kotlinexample.businesscontentapp.rest.BusinessContent
import com.kotlinexample.businesscontentapp.utils.RoomConverter

@Database(entities = [BusinessContent::class], version = 1, exportSchema = false)
@TypeConverters(RoomConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun businessContentDao(): BusinessContentDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "businesses")
                .fallbackToDestructiveMigration()
                .build()
    }

}