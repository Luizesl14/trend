package br.com.trend.infrastructure.port

interface IPort<T>{

    fun findById(id: String): T
    fun findAll(): MutableSet<T>
    fun save(entity: T): T
    fun update(entity: T): T
    fun delete(id: String)
}