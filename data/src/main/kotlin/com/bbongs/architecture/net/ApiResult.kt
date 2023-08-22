package com.bbongs.architecture.net

/**
 * Retrofit 으로 service 호출시에는 ApiResult<T> 형식으로 사용하여야 한다.
 * 해당 success, 혹은 fail 처리는 repository 에서 하여야 하며,
 * common 한 처리들을 extension 함수로 처리할 수 있으나, custom 한 server 의 응답값을 처리해야 할 경우가 있기 때문에 보일러 플레이트 코드 지만 각 repository 에서 error handling 을 하도록 구현
 * common 한 에러들은 exception 으로 message 만을 담아 전달하도록 하였으며, 더 필요한 정보가 있는 경우 repository 에서 담아서 던지도록 해야 한다.
 * 해당 exception 들은 useCase 에서 try..catch 에서 UseCaseResult.Error(e) 를 통해 전달된다.
 */

sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>

    sealed interface Failure : ApiResult<Nothing> {

        data class HttpConnectionError(
            val cause: Throwable,
        ) : Failure

        data class HttpResponseError(
            val code: Int,
            val errorBody: String? = null
        ) : Failure

        data class ServerResponseError(
            val code: Int,
            val errorBody: String? = null
        ) : Failure

        data class BigDataError(
            val code: Int = BIG_DATA_FAILURE_STATUS_CODE,
        ) : Failure

        data class UnknownApiError(val throwable: Throwable) : Failure {
        }

        fun throwCommonException(): Throwable = when (this) {
            is HttpConnectionError,
            is HttpResponseError,
            is ServerResponseError,
            is BigDataError,
            is UnknownApiError -> {
                Exception()
            }
        }
    }

    companion object {
        const val BIG_DATA_FAILURE_STATUS_CODE = 500
    }
}
