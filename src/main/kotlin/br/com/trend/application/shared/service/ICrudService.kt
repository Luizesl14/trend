package br.com.trend.application.shared.service

interface ICrudService<T> {

    fun get(id: String): T
    fun getAll(): MutableSet<T>
    fun setEntity(entity: T): T
    fun update(entity: T): T
    fun delete(id: String)
}