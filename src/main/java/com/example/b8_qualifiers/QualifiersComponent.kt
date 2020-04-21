package com.example.b8_qualifiers

import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier

@Component(
    dependencies = [Dependencies::class],
    modules = [QualifiersModule::class, QualifiersBinds::class]
)
interface QualifiersComponent {

    @CustomQualifier
    fun getCustom(): CharSequence

    @Named("dependency")
    fun getDependency(): CharSequence

    @Named("binds")
    fun getBinds(): CharSequence

    @Named("bindsInstance")
    fun getBindsInstance(): CharSequence

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named("bindsInstance") bindsInstance: CharSequence,
            deps: Dependencies
        ): QualifiersComponent
    }
}

@Qualifier
annotation class CustomQualifier

interface Dependencies {
    @Named("dependency")
    fun getDependencyString(): CharSequence
}

@Module
object QualifiersModule {
    @Provides
    @CustomQualifier
    fun customString(): CharSequence = "customString"
}

@Module
interface QualifiersBinds {
    @Binds
    @Named("binds")
    fun bind(impl: CharSequenceImpl): CharSequence
}

class CharSequenceImpl @Inject constructor() : CharSequence by "impl"


// After conversion


class KotlinQualifiersComponent private constructor(
    private val dependencies: Dependencies,
    private val bindsInstance: CharSequence
) : QualifiersComponent {

    override fun getCustom(): CharSequence = QualifiersModule.customString()
    override fun getDependency(): CharSequence = dependencies.getDependencyString()
    override fun getBinds(): CharSequence = CharSequenceImpl()
    override fun getBindsInstance(): CharSequence = bindsInstance

}