package br.com.trend.presentation.user

import br.com.trend.application.shared.ports.IUserControllerPort
import br.com.trend.model.user.UserDTO
import br.com.trend.presentation.api.ICrudController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val adapter: IUserControllerPort,
): ICrudController<UserDTO, UserDTO> {


    @GetMapping("/{id}")
    override fun get(@PathVariable("id") id: String): ResponseEntity<UserDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(this.adapter.findById(id))
    }

    @GetMapping("/users")
    override fun getAll(): ResponseEntity<MutableSet<UserDTO>> {
        return  ResponseEntity.status(HttpStatus.OK).body(this.adapter.findAll().toMutableSet())
    }

    @PostMapping("/set")
    override fun set(@RequestBody dto: UserDTO): ResponseEntity<UserDTO> {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.adapter.save(dto))
    }

    @PutMapping("/change")
    override fun update(@RequestBody dto: UserDTO): ResponseEntity<UserDTO> {
        return  ResponseEntity.status(HttpStatus.OK).body(this.adapter.update(dto))
    }

    @DeleteMapping("/{id}")
    override fun delete( @PathVariable("id") id: String): ResponseEntity<Void> {
        this.adapter.delete(id);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

}