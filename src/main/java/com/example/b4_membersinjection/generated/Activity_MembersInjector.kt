package com.example.b4_membersinjection.generated

import com.example.b4_membersinjection.Activity
import com.example.b4_membersinjection.Repository
import dagger.MembersInjector
import javax.inject.Provider

class Activity_MembersInjector(
    private val repositoryProvider: Provider<Repository>
) : MembersInjector<Activity> {

    override fun injectMembers(instance: Activity) {
        injectRepository(
            instance,
            repositoryProvider.get()
        )
    }

    companion object {
        fun injectRepository(instance: Activity, repository: Repository) {
            instance.repository = repository
        }
    }
}