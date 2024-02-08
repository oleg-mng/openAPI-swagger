package com.olegmng.openAPIswagger.api;

import com.olegmng.openAPIswagger.model.Person;
import com.olegmng.openAPIswagger.repository.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
@Tag(name="Person")
public class PersonController {
    private final PersonRepository repository;

    @GetMapping
    @Operation(summary = "Get all persons", description = "Download all users in system")
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable Long id){
        return ResponseEntity.ok(repository.findById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person){
        return ResponseEntity.ok(repository.save(person));
    }
}
