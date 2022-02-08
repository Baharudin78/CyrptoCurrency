package com.baharudin.cyrptocurrency.domain.use_case.get_coins

import com.baharudin.cyrptocurrency.common.Resource
import com.baharudin.cyrptocurrency.data.remote.dto.toCoin
import com.baharudin.cyrptocurrency.domain.model.Coin
import com.baharudin.cyrptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e : HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Unexpected error occured"))
        }catch (e : IOException) {
            emit(Resource.Error<List<Coin>>("Couln't reach internet connection"))
        }
    }
}