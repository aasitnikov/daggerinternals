package com.example.c2_custom_scope

import com.example.createSingleton
import dagger.Component
import javax.inject.Inject
import javax.inject.Scope

@Scope
annotation class CustomSingleton

@Component
@CustomSingleton
interface CustomSingletonComponent {
    fun getRepository(): CustomSingletonRepository
}

@CustomSingleton
class CustomSingletonRepository @Inject constructor()


// After conversion


class KotlinCustomSingletonComponent : CustomSingletonComponent {
    private val customSingletonRepositoryProvider = createSingleton { CustomSingletonRepository() }
    override fun getRepository(): CustomSingletonRepository = customSingletonRepositoryProvider()
}