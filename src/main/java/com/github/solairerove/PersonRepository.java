package com.github.solairerove;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

    Flux<Person> findByLastName(Mono<String> lastName);

    @Query("{ 'firstName': ?0, 'lastName': ?1 }")
    Mono<Person> findByFirstNaneAndLastName(String firstName, String lastName);
}
