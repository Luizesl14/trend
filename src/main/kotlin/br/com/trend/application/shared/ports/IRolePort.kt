package br.com.trend.application.shared.ports

import br.com.trend.infrastructure.port.IPort
import br.com.trend.model.user.aggregate.RoleDTO

interface IRoleControllerPort: IPort<RoleDTO> {

}