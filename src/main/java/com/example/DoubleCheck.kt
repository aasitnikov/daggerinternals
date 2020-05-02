package com.example

fun <T> createSingleton(provider: () -> T): () -> T {
    val lazy by kotlin.lazy(provider)
    return { lazy }
}

fun <T> createLazy(provider: () -> T): dagger.Lazy<T> {
    val lazy by kotlin.lazy(provider)
    return dagger.Lazy { lazy }
}


class DelegateFactory<T> : () -> T {

    lateinit var delegate: () -> T
    override fun invoke(): T = delegate()

    companion object {
        fun <T> setDelegate(delegateFactory: () -> T, delegate: () -> T) {
            delegateFactory as DelegateFactory<T>
            delegateFactory.delegate = delegate
        }
    }

}

class InstanceFactory<T>(private val instance: T) : () -> T {
    override fun invoke(): T = instance
    companion object {
        fun <T> create(instance: T) = InstanceFactory(instance)
    }
}