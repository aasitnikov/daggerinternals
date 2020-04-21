package com.example.b5_super_membersinjection.generated

import com.example.b5_super_membersinjection.BaseActivity
import dagger.MembersInjector
import javax.inject.Provider

class BaseActivity_MembersInjector(
    private val stringProvider: Provider<String>
) : MembersInjector<BaseActivity> {

    override fun injectMembers(instance: BaseActivity) {
        injectString(instance, stringProvider.get())
    }

    companion object {
        fun injectString(instance: BaseActivity, string: String) {
            instance.string = string
        }
    }
}