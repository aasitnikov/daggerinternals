package com.example.a3_repository

import dagger.Component
import javax.inject.Inject

@Component
interface RepositoryComponent {
    fun getRepository(): Repository
}

class Repository @Inject constructor(
    apiService: ApiService
)

class ApiService @Inject constructor()


// After conversion


class KotlinRepositoryComponent : RepositoryComponent {
    override fun getRepository() = Repository(ApiService())
}
