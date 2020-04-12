package com.example.a2_repository

import dagger.Component
import javax.inject.Inject

@Component
interface RepositoryComponent {
    fun getRepository(): Repository
}

class Repository @Inject constructor()


// After conversion


class KotlinRepositoryComponent : RepositoryComponent {
    override fun getRepository(): Repository = Repository()
}