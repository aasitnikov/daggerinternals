package com.example.c7_module_in_subcomponent

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Qualifier

@Qualifier
annotation class DefinedInChildComponent

@Module(subcomponents = [ChildComponent::class])
object SubcomponentModule {

    @Provides
    fun getStringFromSubcomponent(
        subcomponent: ChildComponent.Factory
    ): String {
        return subcomponent.create("string").getChildString()
    }
}

@Component(modules = [SubcomponentModule::class])
interface ParentComponent {
    fun getString(): String
}

@Subcomponent
interface ChildComponent {

    @DefinedInChildComponent
    fun getChildString(): String

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance @DefinedInChildComponent string: String
        ): ChildComponent
    }
}


// After conversion


class KotlinParentComponent : ParentComponent {

    override fun getString(): String = SubcomponentModule.getStringFromSubcomponent(ChildComponentFactory())

    private inner class ChildComponentFactory : ChildComponent.Factory {
        override fun create(string: String): ChildComponent = ChildComponentImpl(string)
    }

    private inner class ChildComponentImpl(
        private val childString: String
    ) : ChildComponent {
        override fun getChildString(): String = childString
    }
}
