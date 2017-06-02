package com.graemerg.myfirstsetup

typealias InteractorSupplier = () -> Interactor
interface Interactor {
    fun onReset()
    fun onLoaded()
}