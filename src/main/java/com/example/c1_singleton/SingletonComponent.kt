package com.example.c1_singleton

import com.example.createSingleton
import dagger.Component
import dagger.internal.DoubleCheck
import dagger.internal.Factory
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Component
@Singleton
interface SingletonComponent {
    fun getRepository(): SingletonRepository
}

@Singleton
class SingletonRepository @Inject constructor()


// After conversion


class KotlinSingletonComponent : SingletonComponent {

    private var singletonRepositoryProvider: Provider<SingletonRepository> =
        DoubleCheck.provider(Factory { SingletonRepository() })

    override fun getRepository(): SingletonRepository = singletonRepositoryProvider.get()
}

class SimplifiedKotlinSingletonComponent : SingletonComponent {
    private val singletonRepositoryProvider = createSingleton { SingletonRepository() }
    override fun getRepository(): SingletonRepository = singletonRepositoryProvider()
}