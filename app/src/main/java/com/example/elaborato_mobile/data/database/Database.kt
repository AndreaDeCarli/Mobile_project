package com.example.elaborato_mobile.data.database;

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Profile::class, ShopList::class, Product::class], version = 2)
abstract class Database : RoomDatabase() {
    abstract fun profileDAO(): ProfileDao
    abstract fun shopListDAO(): ShopListDao
    abstract fun productDAO(): ProductDao
}
