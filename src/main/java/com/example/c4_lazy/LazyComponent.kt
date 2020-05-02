package com.example.c4_lazy

import com.example.createLazy
import com.example.createSingleton
import dagger.Component
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Singleton

@Component
@Singleton
interface LazyComponent {
    fun getSingleton(): SingletonClass
    fun createLazy(): Lazy<HashClass>
}

@Singleton
class SingletonClass @Inject constructor()

class HashClass @Inject constructor() {
    override fun toString() = "@" + System.identityHashCode(this).toString(16)
}


// After conversion


class KotlinLazyComponent : LazyComponent {

    private val singletonClassProvider = createSingleton { SingletonClass() }

    override fun getSingleton(): SingletonClass = singletonClassProvider()
    override fun createLazy(): Lazy<HashClass> = createLazy { HashClass() }
}

fun main() {
    val component = KotlinLazyComponent()

    val lazy = component.createLazy()
    println("Lazy instance: " + lazy.get()) // @119d7047
    println("Lazy instance: " + lazy.get()) // @119d7047

    println("1st lazy: " + component.createLazy().get()) // @682a0b20
    println("2nd lazy: " + component.createLazy().get()) // @3d075dc0
}

