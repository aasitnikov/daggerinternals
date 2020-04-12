package com.example.a1_interactor.generated

import com.example.a1_interactor.Interactor
import com.example.a1_interactor.InteractorComponent
import com.example.a1_interactor.InteractorModule
import dagger.internal.Factory
import dagger.internal.Preconditions

class DaggerInteractorComponent private constructor(
    private val interactorModule: InteractorModule
) : InteractorComponent {

    override fun getInteractor() = InteractorModule_InteractorFactory.interactor(interactorModule)

    class Builder {
        private var interactorModule: InteractorModule? = null

        fun interactorModule(interactorModule: InteractorModule): Builder = apply {
            this.interactorModule = Preconditions.checkNotNull(interactorModule)
        }

        fun build(): InteractorComponent {
            return DaggerInteractorComponent(interactorModule!!)
        }
    }

    companion object {
        fun builder(): Builder = Builder()
        fun create(): InteractorComponent = Builder().build()
    }
}

class InteractorModule_InteractorFactory(
    private val module: InteractorModule
) : Factory<Interactor> {

    override fun get(): Interactor = interactor(module)

    companion object {
        fun create(module: InteractorModule): InteractorModule_InteractorFactory {
            return InteractorModule_InteractorFactory(module)
        }

        fun interactor(instance: InteractorModule): Interactor {
            return Preconditions.checkNotNull(
                instance.interactor(),
                "Cannot return null from a non-@Nullable @Provides method"
            )
        }
    }
}
