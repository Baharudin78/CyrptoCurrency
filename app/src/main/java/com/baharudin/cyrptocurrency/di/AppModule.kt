package com.baharudin.cyrptocurrency.di

import com.baharudin.cyrptocurrency.common.Constans.BASE_URL
import com.baharudin.cyrptocurrency.data.remote.CoinApi
import com.baharudin.cyrptocurrency.data.repository.CoinRepositoryImpl
import com.baharudin.cyrptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() : CoinApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(coinApi : CoinApi) : CoinRepository {
        return CoinRepositoryImpl(coinApi)
    }
}