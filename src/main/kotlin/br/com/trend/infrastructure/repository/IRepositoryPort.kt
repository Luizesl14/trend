package br.com.trend.infrastructure.repository

interface IRepositoryPort<S, T>{

    fun findById(id: String): T
    fun findAll(): MutableSet<T>
    fun save(customerDTO: S): T
    fun update(customerDTO: S): T
    fun delete(id: String)
}