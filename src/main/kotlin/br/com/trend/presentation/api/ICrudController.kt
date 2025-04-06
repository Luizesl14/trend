package br.com.trend.model.vo

import org.springframework.http.ResponseEntity

interface ICrudController<S, T> {

    fun getCustomer(id: String): ResponseEntity<T>
    fun getCustomers(): ResponseEntity<MutableSet<T>>
    fun setCustomer(customerDTO: S): ResponseEntity<T>
    fun updateCustomer(customerDTO: S): ResponseEntity<T>
    fun deleteCustomer(id: String): ResponseEntity<Void>
}