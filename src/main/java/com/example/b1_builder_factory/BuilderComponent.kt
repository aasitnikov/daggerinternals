package com.example.b1_builder_factory

import com.example.b1_builder_factory.BuilderComponent.CustomBuilder
import dagger.Component

@Component(modules = [SomeModule::class], dependencies = [SomeDependency::class])
interface BuilderComponent {

    @Component.Builder
    interface CustomBuilder {
        fun withModule(module: SomeModule): CustomBuilder
        fun withDependency(dependency: SomeDependency): CustomBuilder
        fun customBuild(): BuilderComponent
    }
}


// After conversion


class KotlinBuilderComponent private constructor(
    someDependency: SomeDependency
) : BuilderComponent {

    private class Builder : CustomBuilder {
        private var someDependency: SomeDependency? = null

        @Deprecated("This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.")
        override fun withModule(module: SomeModule): Builder = this

        override fun withDependency(dependency: SomeDependency): Builder = apply {
            someDependency = dependency
        }

        override fun customBuild(): BuilderComponent {
            return KotlinBuilderComponent(
                someDependency ?: throw IllegalStateException("SomeDependency must be set")
            )
        }
    }

    companion object {
        fun builder(): CustomBuilder = Builder()
    }
}