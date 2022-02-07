package com.baharudin.cyrptocurrency.data.repository

import com.baharudin.cyrptocurrency.data.remote.CoinApi
import com.baharudin.cyrptocurrency.data.remote.dto.CoinDetailDto
import com.baharudin.cyrptocurrency.data.remote.dto.CoinDto
import com.baharudin.cyrptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return coinApi.getCoins()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDto {
        return coinApi.getCoinById(coinId)
    }
}