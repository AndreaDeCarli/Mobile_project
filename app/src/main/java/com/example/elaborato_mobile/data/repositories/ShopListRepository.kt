package com.example.elaborato_mobile.data.repositories

import android.content.ContentResolver
import com.example.elaborato_mobile.data.database.Product
import com.example.elaborato_mobile.data.database.ProductDao
import com.example.elaborato_mobile.data.database.ProfileDao
import com.example.elaborato_mobile.data.database.ShopList
import com.example.elaborato_mobile.data.database.Profile
import com.example.elaborato_mobile.data.database.ShopListDao
import kotlinx.coroutines.flow.Flow


class ShopListRepository(
    private val shopListDao: ShopListDao,
    private val profileDao: ProfileDao,
    private val productDao: ProductDao
) {
    val profiles: Flow<List<Profile>> = profileDao.getAll()


    val shopLists: Flow<List<ShopList>> = shopListDao.getAll()


    val products: Flow<List<Product>> = productDao.getAll()

    suspend fun addShopList(shopList: ShopList) {
        shopListDao.upsert(shopList)
    }

    suspend fun delete(shopList: ShopList) = shopListDao.delete(shopList)
}
