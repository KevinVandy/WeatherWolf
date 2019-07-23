package com.weatherwolf.controller

import com.weatherwolf.AccountController
import com.weatherwolf.Validators
import com.weatherwolf.security.EmailLog
import com.weatherwolf.security.Role
import com.weatherwolf.security.SearchLog
import com.weatherwolf.security.User
import com.weatherwolf.security.UserRole
import com.weatherwolf.weather.CurrentWeather
import com.weatherwolf.weather.DayForecast
import com.weatherwolf.weather.Location
import com.weatherwolf.weather.SearchResult
import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification


class AccountControllerSpec extends Specification implements DataTest, ControllerUnitTest<AccountController> {

    Class<?>[] getDomainClassesToMock() {
        return [User, Role, UserRole, SearchLog, EmailLog, CurrentWeather, DayForecast, Location, SearchResult] as Class[]
    }

    void "show login page for login user"() {

    }

    void "redirect to login/auth if non-logged in user tries to view account home page"() {

    }

    void "change password successfully"() {

    }

}
