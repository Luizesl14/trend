package br.com.trend.presentation.controller

import br.com.trend.application.shared.adapter.ICustomerControllerPort
import br.com.trend.model.customer.CustomerDTO
import br.com.trend.model.vo.ICrudController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val adapter: ICustomerControllerPort,
): ICrudController<CustomerDTO, CustomerDTO> {


    @GetMapping("/{id}")
    override fun getCustomer(@PathVariable("id") id: String): ResponseEntity<CustomerDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(this.adapter.findById(id))
    }

    @GetMapping("/customers")
    override fun getCustomers(): ResponseEntity<MutableSet<CustomerDTO>> {
        return  ResponseEntity.status(HttpStatus.OK).body(this.adapter.findAll().toMutableSet())
    }

    @PostMapping("/set")
    override fun setCustomer(@RequestBody customerDTO: CustomerDTO): ResponseEntity<CustomerDTO> {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.adapter.save(customerDTO))
    }

    @PutMapping("/change")
    override fun updateCustomer(@RequestBody customerDTO: CustomerDTO): ResponseEntity<CustomerDTO> {
        return  ResponseEntity.status(HttpStatus.OK).body(this.adapter.update(customerDTO))
    }

    @DeleteMapping("/{id}")
    override fun deleteCustomer( @PathVariable("id") id: String): ResponseEntity<Void> {
        this.adapter.delete(id);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

}