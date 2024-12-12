package com.cs407.connectech.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cs407.connectech.model.Converters
import com.cs407.connectech.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
