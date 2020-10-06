package grailsproject

import com.auth.User
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ROYALTY', 'ROLE_COMMON'])
class MainController {

    def index() {
        def username = "testuser"
        [user: username, id: User.findByUsername(username)]
//        render(view: 'index', model: [user: username])

    }
}
