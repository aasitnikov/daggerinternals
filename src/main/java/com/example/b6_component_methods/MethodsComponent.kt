package com.example.b6_component_methods

import dagger.Component
import dagger.MembersInjector
import javax.inject.Inject
import javax.inject.Provider

@Component
interface MethodsComponent {

    fun inject(activity: Activity)
    val activityInjector: MembersInjector<Activity>

    fun getRepository(): Repository
    val repositoryProvider: Provider<Repository>

}

class Activity {

    @Inject
    lateinit var repository: Repository
}

class Repository @Inject constructor()


// After conversion


class KotlinMethodsComponent : MethodsComponent {

    override fun inject(activity: Activity) {
        activity.repository = Repository()
    }
    override val activityInjector get() = MembersInjector { activity: Activity ->
        activity.repository = Repository()
    }

    override fun getRepository() = Repository()
    override val repositoryProvider get() = Provider { Repository() }

}
