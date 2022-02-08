package com.baharudin.cyrptocurrency.domain.use_case.get_coin

import com.baharudin.cyrptocurrency.common.Resource
import com.baharudin.cyrptocurrency.data.remote.dto.toCoin
import com.baharudin.cyrptocurrency.data.remote.dto.toCoinDetail
import com.baharudin.cyrptocurrency.domain.model.Coin
import com.baharudin.cyrptocurrency.domain.model.CoinDetail
import com.baharudin.cyrptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinDetail(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e : HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Unexpected error occured"))
        }catch (e : IOException) {
            emit(Resource.Error<CoinDetail>("Couln't reach internet connection"))
        }
    }
}