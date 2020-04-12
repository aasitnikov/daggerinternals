package com.example.a2_repository.generated

import com.example.a2_repository.Repository
import dagger.internal.Factory

object Repository_Factory : Factory<Repository> {
    override fun get(): Repository = newInstance()
    fun create(): Repository_Factory = this
    fun newInstance(): Repository = Repository()
}