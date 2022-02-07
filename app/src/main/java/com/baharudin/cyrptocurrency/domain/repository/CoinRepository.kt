package com.baharudin.cyrptocurrency.domain.repository

import com.baharudin.cyrptocurrency.data.remote.dto.CoinDetailDto
import com.baharudin.cyrptocurrency.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinDetail(coinId : String) : CoinDetailDto
}