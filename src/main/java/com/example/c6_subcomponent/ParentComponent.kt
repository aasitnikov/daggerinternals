package com.example.c6_subcomponent

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@Component
interface ParentComponent {

    fun createChildComponent(): ChildComponent

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance string: String
        ): ParentComponent
    }
}

@Subcomponent
interface ChildComponent {
    fun getString(): String
}


// After conversion


class KotlinParentComponent(
    private val string: String
) : ParentComponent {

    override fun createChildComponent(): ChildComponent = ChildComponentImpl()

    private inner class ChildComponentImpl : ChildComponent {
        override fun getString(): String = this@KotlinParentComponent.string
    }
}