package br.com.trend.model.vo

interface ICrudService<T> {

    fun getCustomer(id: String): T
    fun getCustomers(): MutableSet<T>
    fun setCustomer(customer: T): T
    fun updateCustomer(customer: T): T
    fun deleteCustomer(id: String)
}