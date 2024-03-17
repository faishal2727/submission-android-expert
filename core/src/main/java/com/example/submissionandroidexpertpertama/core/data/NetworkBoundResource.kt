@file:Suppress("EmptyMethod")

package com.example.submissionandroidexpertpertama.core.data

import com.example.submissionandroidexpertpertama.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

@Suppress("EmptyMethod")
abstract class NetworkBoundResource<ResultType,RequestType> {

    private val result : Flow<Resource<ResultType>> = flow{
        emit(Resource.Loading())
        val db = loadFromDB().first()
        if(shouldFetch(db)){
            emit(Resource.Loading())
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map {
                        Resource.Success(it)
                    })
                }

                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(Resource.Error(apiResponse.message))
                }

                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map {
                        Resource.Success(it)
                    })
                }

            }
        }else {
        emitAll(loadFromDB().map {
            Resource.Success(it)
        })
    }

    }
    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow() = result
}