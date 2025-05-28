package com.example.elaborato_mobile

import android.content.Context
import androidx.room.Room
import com.example.elaborato_mobile.data.database.ShopListDatabase
import com.example.elaborato_mobile.data.repositories.ShopListRepository
import com.example.elaborato_mobile.ui.AddShopListViewModel
import com.example.elaborato_mobile.ui.ShopListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            get(),
            ShopListDatabase::class.java,
            "shop-list")
            .build()
    }

    single {
        ShopListRepository(
            get<ShopListDatabase>().shopListDAO(),
            get<ShopListDatabase>().profileDAO(),
            get<ShopListDatabase>().productDAO())
    }

    viewModel { AddShopListViewModel() }


    viewModel { ShopListViewModel(get()) }
}