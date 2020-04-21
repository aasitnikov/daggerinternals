package com.example.b2_bindsinstance

import dagger.BindsInstance
import dagger.Component
import dagger.internal.InstanceFactory
import javax.inject.Inject
import javax.inject.Provider


@Component
interface BindsInstanceComponent {

    val stringProvider: Provider<String>
    fun getStringWrapper(): StringWrapper

    @Component.Factory
    interface CustomFactory {
        fun customCreate(@BindsInstance string: String): BindsInstanceComponent
    }
}

class StringWrapper @Inject constructor(string: String)


// After conversion


class KotlinBindsInstanceComponent private constructor(
    private val string: String
) : BindsInstanceComponent {

    override val stringProvider: Provider<String> = InstanceFactory.create(string)
    override fun getStringWrapper(): StringWrapper = StringWrapper(string)

    private class Factory : BindsInstanceComponent.CustomFactory {
        override fun customCreate(string: String): BindsInstanceComponent {
            return KotlinBindsInstanceComponent(string)
        }
    }

    companion object {
        fun factory(): BindsInstanceComponent.CustomFactory = Factory()
    }
}

class SimplifiedKotlinBindsInstanceComponent(
    private val string: String
) : BindsInstanceComponent {

    override val stringProvider: Provider<String> = Provider { string }
    override fun getStringWrapper(): StringWrapper = StringWrapper(string)
}