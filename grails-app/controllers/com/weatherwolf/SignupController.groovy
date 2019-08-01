package com.weatherwolf

import com.weatherwolf.security.Role
import com.weatherwolf.security.User
import com.weatherwolf.security.UserRole
import grails.plugin.springsecurity.annotation.Secured
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Secured("permitAll")
class SignupController {

    static allowedMethods = [
            register: 'POST'
    ]

    private final Logger logger = LoggerFactory.getLogger(this.getClass())

    /**
     * Shows the signup page.
     * Some fields can be pre-filled in if showing again after failing signup requirements
     *
     * @return
     */
    def index() {
        render(view: '/signup/index', model: [username: params.username, email: params.email, favoritelocation: params.favoritelocation])
    }

    /** POST only
     *
     * Attempts to register a new user.
     * Must pass validation for username, email, password, and favoriteLocation
     *
     * @param username
     * @param email
     * @param password
     * @param passwordconfirm
     * @param favoritelocation
     * @return
     */
    def register(String username, String email, String password, String passwordconfirm, String favoritelocation) {
        def u, r
        logger.info("New user, ${username} attempting to register")
        flash.error = Validators.validateSignup(username, email, password, passwordconfirm)
        logger.info("message: " + flash.error)
        if (flash.error) {
            redirect(url: "/signup/index?username=${username}&email=${email}&favoritelocation=${favoritelocation}") //user error
        } else { //should be valid
            logger.info("Creating user: ${username}")
            u = new User(username: username, email: email, password: password, favoriteLocation: favoritelocation, dateCreated: new Date())
            try {
                logger.debug("saving user")
                u.save(flush: true, failOnError: true)
                logger.debug("user saved")
                r = Role.findByAuthority('ROLE_CLIENT')
                UserRole.create(u, r, true)
                logger.info("User Role saved")
                flash.success = "${u.username}" + message(code: 'msg.youraccountcreated', default: ", Your Account has been Created")
                redirect(url: "/login/index?username=${username}") //success
            } catch (Exception e) {
                flash.error = message(code: 'msg.invalidsignup', default: 'Signup not valid.')
                logger.warn("Could not create user: ${username}")
                logger.error(e.toString())
                redirect(url: "/signup/index?username=${username}&email=${email}&favoritelocation=${favoritelocation}") //unknown error
            }
        }
    }
}
