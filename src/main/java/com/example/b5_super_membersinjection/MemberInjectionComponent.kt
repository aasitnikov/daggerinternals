package com.example.b5_super_membersinjection

import com.example.b5_super_membersinjection.generated.BaseActivity_MembersInjector
import dagger.BindsInstance
import dagger.Component
import java.math.BigInteger
import javax.inject.Inject

abstract class BaseActivity {
    @Inject
    lateinit var string: String
}

class ChildActivity : BaseActivity() {
    @Inject
    lateinit var bigInt: BigInteger
}

@Component
interface MemberInjectionComponent {

    fun injectChild(activity: ChildActivity)
    fun injectBase(activity: BaseActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance string: String,
            @BindsInstance bigInt: BigInteger
        ): MemberInjectionComponent
    }
}

// ---------

class KotlinMemberInjectionComponent(
    private val string: String,
    private val bigInt: BigInteger
) : MemberInjectionComponent {

    override fun injectChild(activity: ChildActivity) {
        injectChildActivity(activity)
    }

    override fun injectBase(activity: BaseActivity) {
        injectBaseActivity(activity)
    }

    private fun injectBaseActivity(instance: BaseActivity): BaseActivity? {
        BaseActivity_MembersInjector.injectString(instance, string)
        return instance
    }

    private fun injectChildActivity(instance: ChildActivity): ChildActivity {
        BaseActivity_MembersInjector.injectString(instance, string)
        ChildActivity_MembersInjector.injectBigInt(instance, bigInt)
        return instance
    }
}

class SimplifiedKotlinMemberInjectionComponent(
    private val string: String,
    private val bigInt: BigInteger
) : MemberInjectionComponent {

    override fun injectChild(activity: ChildActivity) {
        activity.string = string
        activity.bigInt = bigInt
    }

    override fun injectBase(activity: BaseActivity) {
        activity.string = string
    }
}