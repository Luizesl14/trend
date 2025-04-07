package br.com.trend.model.customer

import br.com.trend.model.customer.aggregate.Address
import br.com.trend.model.customer.aggregate.Phone
import br.com.trend.model.persona.Persona
import br.com.trend.model.user.User
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "customers")
 class Customer(

   @Id
   val id: ObjectId? = ObjectId(),

   @DBRef
    val persona: MutableSet<Persona> = mutableSetOf(),

   @DBRef
    val users: MutableSet<User> = mutableSetOf(),

   @DBRef
    val phone: MutableSet<Phone> = mutableSetOf(),

   @DBRef
    val addresses: MutableSet<Address> = mutableSetOf()

){
   override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (javaClass != other?.javaClass) return false

      other as Customer

      return id == other.id
   }

   override fun hashCode(): Int {
      return id.hashCode()
   }
}
