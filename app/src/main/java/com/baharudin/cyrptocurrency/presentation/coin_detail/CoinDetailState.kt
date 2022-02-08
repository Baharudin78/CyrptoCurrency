package com.baharudin.cyrptocurrency.presentation.coin_detail

import com.baharudin.cyrptocurrency.domain.model.Coin
import com.baharudin.cyrptocurrency.domain.model.CoinDetail

data class CoinDetailState (
    val isLoading : Boolean = false,
    val coin : CoinDetail ? = null,
    val error : String = ""
    )