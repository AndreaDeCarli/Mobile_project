package com.example.elaborato_mobile.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import androidx.room.Embedded
import androidx.room.Junction

@Entity
data class ShopList(
    @PrimaryKey(autoGenerate = true)
    val shoplistId: Int = 0,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val profileId: Int,

    @ColumnInfo
    val iconId: Int,

    @ColumnInfo
    val data: String
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

@Entity(primaryKeys= ["shopListId", "productId"])
data class ShopListProductCrossRef(
    val shopListId: Long,
    val productId: Long
)


data class ShopListwithProduct(
    @Embedded val shopList: ShopList,
    @Relation(
        parentColumn= "shopListId",
        entityColumn= "productId",
        associateBy= Junction(ShopListProductCrossRef::class)
    )
    val products: List<Product>
)

data class ProfileWithShopList(
    @Embedded val profile: Profile,
    @Relation(
        parentColumn= "id",
        entityColumn= "profileId"
    )
    val shopLists: List<ShopList>
)