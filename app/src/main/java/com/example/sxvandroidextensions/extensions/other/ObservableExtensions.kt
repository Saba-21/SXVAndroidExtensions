package com.example.sxvandroidextensions.extensions.other

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> T.makeObservable():
        Observable<T> = Observable.just<T>(this)

fun <T> (() -> T).fromCallable():
        Observable<Boolean> = Observable.fromCallable {
    this.invoke()
    true
}

fun <T> Observable<T>.async():
        Observable<T> = this
    .subscribeOn(Schedulers.newThread())
    .observeOn(AndroidSchedulers.mainThread())