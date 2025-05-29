package com.example.elaborato_mobile

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import androidx.room.migration.Migration
import com.example.elaborato_mobile.data.database.ShopListDatabase
import com.example.elaborato_mobile.data.repositories.PreferencesRepository
import com.example.elaborato_mobile.data.repositories.ShopListRepository
import com.example.elaborato_mobile.ui.AddShopListViewModel
import com.example.elaborato_mobile.ui.ProfilePreferenceViewModel
import com.example.elaborato_mobile.ui.ShopListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val Context.dataStore by preferencesDataStore("preferences")

val appModule = module {
    single { get<Context>().dataStore }

    single {
        Room.databaseBuilder(
            get(),
            ShopListDatabase::class.java,
            "shop-list").fallbackToDestructiveMigration()
            .build()
    }

    single {
        ShopListRepository(
            get<ShopListDatabase>().shopListDAO(),
            get<ShopListDatabase>().profileDAO(),
            get<ShopListDatabase>().productDAO())
    }

    single { PreferencesRepository(get()) }

    viewModel { AddShopListViewModel() }

    viewModel { ProfilePreferenceViewModel(get()) }

    viewModel { ShopListViewModel(get()) }
}