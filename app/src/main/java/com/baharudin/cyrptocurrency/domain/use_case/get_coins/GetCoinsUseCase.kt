package com.baharudin.cyrptocurrency.domain.use_case.get_coins

import com.baharudin.cyrptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

}