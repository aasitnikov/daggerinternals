package com.example.a4_modules.generated

import com.example.a4_modules.ApiService
import com.example.a4_modules.Interceptor
import com.example.a4_modules.NetworkModule
import dagger.internal.Factory
import javax.inject.Provider

class NetworkModule_CreateApiServiceFactory(
    private val module: NetworkModule,
    private val interceptorProvider: Provider<Interceptor>
) : Factory<ApiService> {

    override fun get(): ApiService {
        return createApiService(module, interceptorProvider.get())
    }

    companion object {

        // create() omitted for brevity

        fun createApiService(
            instance: NetworkModule,
            interceptor: Interceptor
        ): ApiService {
            return instance.createApiService(interceptor)
        }
    }
}
