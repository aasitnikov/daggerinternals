package com.example.a4_modules

import dagger.Module
import dagger.Provides

class OkHttpClient
class ApiService
class Interceptor

@Module
class NetworkModule(private val client: OkHttpClient) {

    @Provides
    fun createApiService(interceptor: Interceptor): ApiService {
        return create<ApiService>(client, interceptor)
    }
}

private fun <T> create(client: OkHttpClient, interceptor: Interceptor): T = TODO()