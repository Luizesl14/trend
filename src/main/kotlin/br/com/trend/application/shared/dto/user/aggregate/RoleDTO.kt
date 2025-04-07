package br.com.trend.model.user.aggregate

import org.bson.types.ObjectId


data class RoleDTO(

    var id: ObjectId? = null,
    var name: String,
    var isActive: Boolean = false
)