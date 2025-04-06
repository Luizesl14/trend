package br.com.trend.infrastructure.adapter

interface IRepositoryPort<T>{

    fun findById(id: String): T
    fun findAll(): MutableSet<T>
    fun save(entity: T): T
    fun update(entity: T): T
    fun delete(id: String)
}