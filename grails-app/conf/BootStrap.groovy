import com.pucminas.security.Role
import com.pucminas.security.User
import com.pucminas.security.UserRole

class BootStrap {

    def init = { servletContext ->
        Role.init()
        if(!User.findByUsername("admin")) {
            User user = new User()
            user.username = "admin"
            user.password = "admin"
            user.save()
            def roles = Role.getPermissoes()
            roles.each { Role _role ->
                UserRole.create(user, _role)
            }
            user.save(flush: true)
        }

    }
    def destroy = {
    }
}
