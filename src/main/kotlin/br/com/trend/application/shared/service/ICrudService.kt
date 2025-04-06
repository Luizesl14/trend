package br.com.trend.application.shared.adapter.service

interface ICrudService<T> {

    fun getCustomer(id: String): T
    fun getCustomers(): MutableSet<T>
    fun setCustomer(entity: T): T
    fun updateCustomer(entity: T): T
    fun deleteCustomer(id: String)
}