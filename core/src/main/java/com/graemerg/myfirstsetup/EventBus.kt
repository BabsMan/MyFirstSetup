package com.graemerg.myfirstsetup

interface EventBus {
    fun register(subscriber: Any)
    fun unregister(subscriber: Any)

    fun post(event:Any)
}
