package com.example.c3_reusable

import dagger.Component
import dagger.Reusable
import dagger.internal.Factory
import dagger.internal.SingleCheck
import javax.inject.Inject
import javax.inject.Provider

@Component
interface ReusableComponent {
    fun getRepository(): ReusableRepository
}

@Reusable
class ReusableRepository @Inject constructor()


// After conversion


class KotlinReusableComponent : ReusableComponent {

    private val reusableRepositoryProvider: Provider<ReusableRepository> =
        SingleCheck.provider(Factory { ReusableRepository() })

    override fun getRepository(): ReusableRepository = reusableRepositoryProvider.get()
}
