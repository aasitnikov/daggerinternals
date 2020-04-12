package com.example.a3_repository.generated

import com.example.a3_repository.ApiService
import com.example.a3_repository.Repository
import dagger.internal.Factory
import javax.inject.Provider

class Repository_Factory(
    private val apiServiceProvider: Provider<ApiService>
) : Factory<Repository> {

    override fun get(): Repository {
        return newInstance(apiServiceProvider.get())
    }

    companion object {
        fun create(
            apiServiceProvider: Provider<ApiService>
        ): Repository_Factory {
            return Repository_Factory(apiServiceProvider)
        }

        fun newInstance(
            apiService: ApiService
        ): Repository {
            return Repository(apiService)
        }
    }
}