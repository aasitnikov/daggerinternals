package com.example.b1_builder_factory

import dagger.Component

@Component(modules = [SomeModule::class], dependencies = [SomeDependency::class])
interface FactoryComponent {

    @Component.Factory
    interface CustomFactory {
        fun customCreate(
            module: SomeModule,
            dependency: SomeDependency
        ): FactoryComponent
    }
}


// After conversion


class KotlinFactoryComponent private constructor(
    someDependency: SomeDependency
) : FactoryComponent {

    private class Factory : FactoryComponent.CustomFactory {
        override fun customCreate(
            module: SomeModule,
            dependency: SomeDependency
        ): FactoryComponent {
            return KotlinFactoryComponent(dependency)
        }
    }

    companion object {
        fun factory(): FactoryComponent.CustomFactory = Factory()
    }
}

