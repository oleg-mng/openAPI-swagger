package com.olegmng.openAPIswagger.service;

import com.olegmng.openAPIswagger.model.Person;
import com.olegmng.openAPIswagger.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;
@Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.SERIALIZABLE)
    public void updatePerson(Long id, String newName, Integer newAge){
        Person person = repository.findById(id).orElseThrow();

        person.setName(newName);
        repository.save(person);

        fail();

        person.setAge(newAge);
        repository.save(person);

    }
    public void fail(){
        throw new RuntimeException("fail");
    }
}
