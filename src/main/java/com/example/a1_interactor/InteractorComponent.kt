package com.example.a1_interactor

import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [InteractorModule::class])
interface InteractorComponent {
    fun getInteractor(): Interactor
}

@Module
class InteractorModule {

    @Provides
    fun interactor(): Interactor = Interactor()
}

class Interactor


// After conversion


class KotlinInteractorComponent(
    private val interactorModule: InteractorModule = InteractorModule()
) : InteractorComponent {

    override fun getInteractor(): Interactor = interactorModule.interactor()

}

