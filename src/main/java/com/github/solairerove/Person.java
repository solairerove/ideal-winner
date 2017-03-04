package com.github.solairerove;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "people")
public class Person implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean isHuman;

    public Person(String firstName, String lastName, Integer age, Boolean isHuman) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isHuman = isHuman;
    }
}
