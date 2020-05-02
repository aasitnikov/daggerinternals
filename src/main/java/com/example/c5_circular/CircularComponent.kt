package com.example.c5_circular

import com.example.DelegateFactory
import com.example.createLazy
import com.example.createSingleton
import dagger.Component
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Singleton

class HttpClient @Inject constructor(
    val authenticator: Authenticator
)

class Authenticator @Inject constructor(
    val apiService: Lazy<ApiService>
) {
    fun authenticate() {
        apiService.get().doAuthCall() // Use apiService to authenticate
    }
}

@Singleton
class ApiService @Inject constructor(
    val client: HttpClient
)

@Component
@Singleton
interface CircularComponent {
    fun getApiService(): ApiService
}

fun ApiService.doAuthCall() = Unit


// After conversion


class KotlinCircularComponent : CircularComponent {

    private val apiServiceProvider = DelegateFactory<ApiService>()
    private val authenticatorProvider = { Authenticator(createLazy(apiServiceProvider)) }
    private val httpClientProvider = { HttpClient(authenticatorProvider()) }

    init {
        val delegate = createSingleton { ApiService(httpClientProvider()) }
        DelegateFactory.setDelegate(apiServiceProvider, delegate)
    }

    override fun getApiService(): ApiService = apiServiceProvider()
}

class SimplifiedKotlinCircularComponent : CircularComponent {

    private lateinit var apiServiceProviderDelegate: () -> ApiService
    private val apiServiceProvider = { apiServiceProviderDelegate() }
    private val authenticatorProvider = { Authenticator(createLazy(apiServiceProvider)) }
    private val httpClientProvider = { HttpClient(authenticatorProvider()) }

    init {
        apiServiceProviderDelegate = createSingleton { ApiService(httpClientProvider()) }
    }

    override fun getApiService(): ApiService = apiServiceProvider()
}