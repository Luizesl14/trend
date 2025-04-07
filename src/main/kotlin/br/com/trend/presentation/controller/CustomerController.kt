package br.com.trend.presentation.controller

import br.com.trend.application.shared.ports.ICustomerControllerPort
import br.com.trend.model.customer.CustomerDTO
import br.com.trend.presentation.api.ICrudController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val adapter: ICustomerControllerPort,
): ICrudController<CustomerDTO, CustomerDTO> {


    @GetMapping("/{id}")
    override fun get(@PathVariable("id") id: String): ResponseEntity<CustomerDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(this.adapter.findById(id))
    }

    @GetMapping("/customers")
    override fun getAll(): ResponseEntity<MutableSet<CustomerDTO>> {
        return  ResponseEntity.status(HttpStatus.OK).body(this.adapter.findAll().toMutableSet())
    }

    @PostMapping("/set")
    override fun set(@RequestBody dto: CustomerDTO): ResponseEntity<CustomerDTO> {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.adapter.save(dto))
    }

    @PutMapping("/change")
    override fun update(@RequestBody dto: CustomerDTO): ResponseEntity<CustomerDTO> {
        return  ResponseEntity.status(HttpStatus.OK).body(this.adapter.update(dto))
    }

    @DeleteMapping("/{id}")
    override fun delete( @PathVariable("id") id: String): ResponseEntity<Void> {
        this.adapter.delete(id);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

}