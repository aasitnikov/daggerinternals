package com.example.b10_multibindings

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.internal.MapBuilder
import dagger.internal.SetBuilder
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey

@Component(modules = [MultibindingsMapModule::class, MultibindingsSetModule::class])
interface MultibindingsComponent {
    fun createMap(): Map<String, Int>
    fun createSet(): Set<Double>
}

@Module
object MultibindingsMapModule {

    @Provides
    @IntoMap
    @StringKey("one")
    fun provideOne(): Int = 1

    @Provides
    @IntoMap
    @StringKey("two")
    fun provideTwo(): Int = 2
}

@Module
object MultibindingsSetModule {

    @Provides
    @IntoSet
    fun providePi(): Double = Math.PI

    @Provides
    @IntoSet
    fun provideE(): Double = Math.E
}


// After conversion


class KotlinMultibindingsComponent : MultibindingsComponent {
    override fun createMap(): Map<String, Int> =
        MapBuilder.newMapBuilder<String, Int>(2)
            .put("one", MultibindingsMapModule.provideOne())
            .put("two", MultibindingsMapModule.provideTwo())
            .build()

    override fun createSet(): Set<Double> =
        SetBuilder.newSetBuilder<Double>(2)
            .add(MultibindingsSetModule.providePi())
            .add(MultibindingsSetModule.provideE())
            .build()
}