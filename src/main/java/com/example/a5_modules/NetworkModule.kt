package com.example.a5_modules

import dagger.Module
import dagger.Provides

class OkHttpClient
class ApiService
class Interceptor

@Module
object NetworkModule {

    @Provides
    fun createApiService(client: OkHttpClient, interceptor: Interceptor): ApiService {
        return create<ApiService>(client, interceptor)
    }
}

private fun <T> create(client: OkHttpClient, interceptor: Interceptor): T = TODO()