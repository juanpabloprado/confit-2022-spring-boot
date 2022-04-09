package com.example.confit

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UserRepositorySpec extends Specification {

    @Autowired
    UserRepository userRepository

    void 'save a new user and find it'() {
        given: 'a new user'
        User u = new User("John")

        when: 'saving it'
        userRepository.save(u)

        then: 'it is saved'
        noExceptionThrown()
        u.name == "John"
        u.id

        when:
        Optional<User> userFound = userRepository.findByName("John")

        then:
        userFound.isPresent()
        userFound.get().id == u.id
    }
}
