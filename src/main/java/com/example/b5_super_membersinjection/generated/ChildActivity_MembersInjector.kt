package com.example.b5_super_membersinjection.generated

import com.example.b5_super_membersinjection.ChildActivity
import dagger.MembersInjector
import java.math.BigInteger
import javax.inject.Provider

class ChildActivity_MembersInjector(
    private val stringProvider: Provider<String>,
    private val bigIntProvider: Provider<BigInteger>
) : MembersInjector<ChildActivity> {

    override fun injectMembers(instance: ChildActivity) {
        BaseActivity_MembersInjector.injectString(instance, stringProvider.get())
        injectBigInt(instance, bigIntProvider.get())
    }

    companion object {
        fun injectBigInt(instance: ChildActivity, bigInt: BigInteger) {
            instance.bigInt = bigInt
        }
    }
}