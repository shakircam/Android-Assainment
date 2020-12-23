package com.example.helloandroid.core

interface DataFetchCallback<T> {
    fun onSuccess(data: T)
    fun onError(throwable: Throwable)
}