package br.com.trend.application.shared.util

abstract class OptionalLike<T> {

    abstract fun isPresent(): Boolean
    abstract fun get(): T

    fun isEmpty() = !isPresent()

    inline fun ifPresent(action: (T) -> Unit) {
        if (isPresent()) action(get())
    }

    inline fun ifPresentOrElse(action: (T) -> Unit, orElse: () -> Unit) {
        if (isPresent()) action(get()) else orElse()
    }

    inline fun <U> map(transform: (T) -> U): OptionalLike<U> =
        if (isPresent()) Some(transform(get())) else None()

    inline fun <U> flatMap(transform: (T) -> OptionalLike<U>): OptionalLike<U> =
        if (isPresent()) transform(get()) else None()

    fun orElse(other: T): T = if (isPresent()) get() else other

    fun orElseGet(supplier: () -> T): T = if (isPresent()) get() else supplier()

    fun orElseThrow(exceptionSupplier: () -> Throwable): T =
        if (isPresent()) get() else throw exceptionSupplier()

    fun orNull(): T? = if (isPresent()) get() else null

    fun stream(): Sequence<T> = if (isPresent()) sequenceOf(get()) else emptySequence()

    fun filter(predicate: (T) -> Boolean): OptionalLike<T> =
        if (!isPresent() || predicate(get())) this else None()
}

class Some<T>(private val value: T) : OptionalLike<T>() {
    override fun isPresent() = true
    override fun get(): T = value
}

class None<T> : OptionalLike<T>() {
    override fun isPresent() = false
    override fun get(): T = throw NoSuchElementException("No value present")
}

fun <T> optionalOf(value: T?): OptionalLike<T> =
    if (value != null) Some(value) else None()
