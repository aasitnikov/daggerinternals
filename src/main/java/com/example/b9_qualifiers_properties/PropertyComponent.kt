package com.example.b9_qualifiers_properties

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component
interface PropertyComponent {

    // @Named("binds")
    @get:Named("binds")
    val instance: String

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named("binds") instance: String
        ): PropertyComponent
    }
}
