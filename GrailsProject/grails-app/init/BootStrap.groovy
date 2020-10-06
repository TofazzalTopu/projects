import com.auth.Role
import com.auth.User
import com.auth.UserRole

class BootStrap {

    def init = { servletContext ->
        User admin = new User(username:'admin', password:'secret', enabled:true).save()
        User john = new User(username:'john', password:'secret', enabled:true).save()
        User jane = new User(username:'jane', password:'secret', enabled:true).save()
        Role royalty = new Role(authority: 'ROLE_ROYALTY').save()
        Role common = new Role(authority: 'ROLE_COMMON').save()
        UserRole.create(admin, royalty)
        UserRole.create(admin, common)
        UserRole.create(john, common)


    }
    def destroy = {
    }
}
