package com.example.a5_modules.generated

import com.example.a5_modules.ApiService
import com.example.a5_modules.Interceptor
import com.example.a5_modules.NetworkModule
import com.example.a5_modules.OkHttpClient
import dagger.internal.Factory
import javax.inject.Provider

class NetworkModule_CreateApiServiceFactory(
    private val clientProvider: Provider<OkHttpClient>,
    private val interceptorProvider: Provider<Interceptor>
) : Factory<ApiService> {

    override fun get(): ApiService {
        return createApiService(
            clientProvider.get(),
            interceptorProvider.get()
        )
    }

    companion object {
        fun createApiService(
            client: OkHttpClient,
            interceptor: Interceptor
        ): ApiService {
            return NetworkModule.createApiService(client, interceptor)
        }
    }
}