package com.github.solairerove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "/api", produces = APPLICATION_JSON_UTF8_VALUE)
public class PersonController {

    private final PersonRepository people;

    @Autowired
    public PersonController(PersonRepository people) {
        this.people = people;
    }

//    @GetMapping("/people")
//    Flux<String> nameByLastName(@RequestParam Mono<String> lastName) {
//        return people
//                .findByLastName(lastName)
//                .map(Person::getFirstName);
//    }

    @GetMapping("/people")
    Flux<Person> getAll() {
        return people.findAll();
    }

    @PostMapping("/people")
    Mono<Person> add() {
        return people.save(new Person("John", "Condom", 20, false));
    }
}
