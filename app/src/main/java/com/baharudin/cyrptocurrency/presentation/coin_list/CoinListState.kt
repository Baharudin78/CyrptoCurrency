package com.baharudin.cyrptocurrency.presentation.coin_list

import com.baharudin.cyrptocurrency.domain.model.Coin

data class CoinListState (
    val isLoading : Boolean = false,
    val coin : List<Coin> = emptyList(),
    val error : String = ""
    )