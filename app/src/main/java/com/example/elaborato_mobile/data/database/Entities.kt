package com.example.elaborato_mobile.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShopList(
    @PrimaryKey(autoGenerate = true)
    val shopListId: Int = 0,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val profileId: Int,

    @ColumnInfo
    val iconId: Int,

    @ColumnInfo
    val date: String
)

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    val productId: Int = 0,

    @ColumnInfo
    val profileId: Int,

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val imageUri: String,

    @ColumnInfo
    val favorite: Boolean
)

@Entity
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val name: String,
    )