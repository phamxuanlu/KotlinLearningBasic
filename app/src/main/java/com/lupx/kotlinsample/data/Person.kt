package com.lupx.kotlinsample.data

class Person {
    var name: String = ""
        get() = field.toUpperCase()
        set(value) {
            field = "My name is ${value}"
        }
}