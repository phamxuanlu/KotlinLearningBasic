package com.lupx.kotlinsample.domain.commands

public interface Command<out T>{
    fun execute(): T
}