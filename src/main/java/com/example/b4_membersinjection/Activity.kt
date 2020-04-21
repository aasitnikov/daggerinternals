package com.example.b4_membersinjection

import javax.inject.Inject

interface Repository

class Activity {

    @Inject
    lateinit var repository: Repository
}
