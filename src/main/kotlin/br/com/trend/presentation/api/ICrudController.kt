package br.com.trend.presentation.api

import org.springframework.http.ResponseEntity

interface ICrudController<S, T> {

    fun get(id: String): ResponseEntity<T>
    fun getAll(): ResponseEntity<MutableSet<T>>
    fun set(dto: S): ResponseEntity<T>
    fun update(dto: S): ResponseEntity<T>
    fun delete(id: String): ResponseEntity<Void>
}