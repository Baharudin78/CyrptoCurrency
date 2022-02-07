package com.baharudin.cyrptocurrency.data.remote

import com.baharudin.cyrptocurrency.data.remote.dto.CoinDetailDto
import com.baharudin.cyrptocurrency.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId")coinId : String) : CoinDetailDto
}