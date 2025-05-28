package com.example.elaborato_mobile.ui

import androidx.lifecycle.ViewModel
import com.example.elaborato_mobile.data.database.ShopList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AddShopListState(
    val title: String = "",
    val date: String = "",

) {
    val canSubmit get() = title.isNotBlank() && date.isNotBlank()

    fun toShopList() = ShopList(
        title = title,
        date = date,
        profileId = 0,
        iconId = 0,
    )
}

interface AddShopListActions {
    fun setTitle(title: String)
    fun setDate(date: String)

}

class AddShopListViewModel : ViewModel() {
    private val _state = MutableStateFlow(AddShopListState())
    val state = _state.asStateFlow()

    val actions = object : AddShopListActions {
        override fun setTitle(title: String) =
            _state.update { it.copy(title = title) }

        override fun setDate(date: String) =
            _state.update { it.copy(date = date) }


    }
}
