package com.example.elaborato_mobile.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao{
    @Query("SELECT * FROM profile")
    fun getAll(): Flow<List<Profile>>

    @Upsert
    fun upsert(profile: Profile)

    @Delete
    fun delete(profile: Profile)


}

@Dao
interface ShopListDao{
    @Query("SELECT * FROM shoplist")
    fun getAll(): Flow<List<ShopList>>

    @Upsert
    suspend fun upsert(shopList: ShopList)

    @Delete
    suspend fun delete(shopList: ShopList)

}

@Dao
interface ProductDao{
    @Query("SELECT * FROM product")
    fun getAll(): Flow<List<Product>>

    @Upsert
    fun upsert(product: Product)

    @Delete
    fun delete(product: Product)
}

