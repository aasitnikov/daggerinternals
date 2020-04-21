package com.example.b7_binds

import com.example.createSingleton
import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Inject
import javax.inject.Singleton

@Component(modules = [BinderModule::class])
interface BindsComponent {
    fun getCharSequence(): CharSequence
}

@Module
interface BinderModule {
    @Binds
    fun bindCharSequence(impl: CharSequenceImpl): CharSequence
}

class CharSequenceImpl @Inject constructor() : CharSequence by "hello"


// After conversion


class KotlinBindsComponent : BindsComponent {
    override fun getCharSequence(): CharSequence = CharSequenceImpl()
}


// Singleton version of binds



@Singleton
@Component(modules = [BinderSingletonModule::class])
interface BindsSingletonComponent {
    fun getCharSequence(): CharSequence
}

@Module
interface BinderSingletonModule {
    @Binds
    @Singleton
    fun bindCharSequence(hello: CharSequenceImpl): CharSequence
}


// After conversion


class KotlinBindsSingletonComponent : BindsSingletonComponent {
    private val bindCharSequenceProvider = createSingleton { CharSequenceImpl() }

    override fun getCharSequence(): CharSequence = bindCharSequenceProvider()
}