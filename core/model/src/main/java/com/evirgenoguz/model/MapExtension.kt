package com.evirgenoguz.model

inline fun <I, O> I.mapTo(crossinline mapper: (I) -> O): O {
    return mapper(this)
}