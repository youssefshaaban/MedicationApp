package com.example.domain.usecases


import com.example.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginUseCase @Inject constructor() {
    operator fun invoke(password:String,userName:String): Flow<Resource<Boolean>> =
        flow{
            delay(2000)
            emit(Resource.Success(true))
        }.flowOn(Dispatchers.IO)
}