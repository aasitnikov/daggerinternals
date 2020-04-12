package com.example.a6_dependencies

import dagger.Component
import javax.inject.Provider

@Component(dependencies = [Dependencies::class])
interface DependenciesComponent {
    val stringProviderFromDependencies: Provider<String>
    fun getStringFromDependencies(): String
}

interface Dependencies {
    fun provideString(): String
}


// After conversion


class KotlinDependenciesComponent(
    private val dependenciesParam: Dependencies
) : DependenciesComponent {

    override val stringProviderFromDependencies: Provider<String> =
        com_example_a6_dependencies_Dependencies_provideString(dependenciesParam)

    override fun getStringFromDependencies(): String {
        return dependenciesParam.provideString()
    }


    private class com_example_a6_dependencies_Dependencies_provideString internal constructor(
        private val dependencies: Dependencies
    ) : Provider<String> {
        override fun get(): String = dependencies.provideString()
    }
}

class SimplifiedKotlinDependenciesComponent(
    private val dependenciesParam: Dependencies
) : DependenciesComponent {

    override val stringProviderFromDependencies = Provider { dependenciesParam.provideString() }
    override fun getStringFromDependencies(): String = dependenciesParam.provideString()

}