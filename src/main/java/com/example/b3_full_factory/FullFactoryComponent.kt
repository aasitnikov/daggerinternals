package com.example.b3_full_factory

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [FullFactoryModule::class],
    dependencies = [FullFactoryDependencies::class]
)
interface FullFactoryComponent {

    fun getObject(): Any
    fun getString(): String
    fun getDouble(): Double

    @Component.Factory
    interface Factory {
        fun create(
            module: FullFactoryModule,
            dependency: FullFactoryDependencies,
            @BindsInstance double: Double
        ): FullFactoryComponent
    }
}

@Module
class FullFactoryModule(@get:Provides val someObject: Any)

interface FullFactoryDependencies {
    val stringFromDependency: String
}


// After conversion


class KotlinFullFactoryComponent private constructor(
    private val fullFactoryModule: FullFactoryModule,
    private val fullFactoryDependencies: FullFactoryDependencies,
    private val double: Double
) : FullFactoryComponent {

    override fun getObject(): Any = fullFactoryModule.someObject
    override fun getString(): String = fullFactoryDependencies.stringFromDependency
    override fun getDouble(): Double = double

    private class Factory : FullFactoryComponent.Factory {
        override fun create(
            module: FullFactoryModule,
            dependency: FullFactoryDependencies,
            double: Double
        ): FullFactoryComponent {
            return KotlinFullFactoryComponent(module, dependency, double)
        }
    }

    companion object {
        fun factory(): FullFactoryComponent.Factory = Factory()
    }
}