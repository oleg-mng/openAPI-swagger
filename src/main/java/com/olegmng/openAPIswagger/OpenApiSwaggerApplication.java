package com.olegmng.openAPIswagger;

import com.olegmng.openAPIswagger.model.Person;
import com.olegmng.openAPIswagger.repository.PersonRepository;
import com.olegmng.openAPIswagger.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

/**
 * connecting swagger and open-api3
 * https://www.baeldung.com/spring-rest-openapi-documentation
 */

@SpringBootApplication
@RequiredArgsConstructor
public class OpenApiSwaggerApplication {

    private final PersonRepository repository;
    private final PersonService service;

    public static void main(String[] args) {

        SpringApplication.run(OpenApiSwaggerApplication.class, args);

    }

//    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        Person person = preparePerson();
        doUpdate(person.getId());

        repository.findById(person.getId())
                .ifPresent(System.out::println);

    }

    private void doUpdate(Long id) {
        try {
            service.updatePerson(id, "Update", 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        };


    }

    private Person preparePerson() {
        Person person = new Person();
        person.setId(1L);
        person.setName("Initial");
        person.setAge(50);
        return repository.save(person);
    }

}
