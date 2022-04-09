package com.example.confit

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerSpec extends Specification {

    @Autowired
    TestRestTemplate template

    void 'save a new user'() {
        given:
        var user = new User("Penny")

        when:
        ResponseEntity<User> response = template.postForEntity("/users", user, User)

        then:
        noExceptionThrown()
        response.statusCode == HttpStatus.CREATED
        response.getBody().name == "Penny"
        response.getBody().id

    }
}
