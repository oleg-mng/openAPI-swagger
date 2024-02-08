package com.olegmng.openAPIswagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
@Schema(name = "User")
public class Person {

    @Id
    @Schema(name = "Id", minimum = "0", maxLength=2147000000)
    private Long id;

    @Column(name = "name")
    @Schema(name = "Name")
    private String name;

    @Column(name = "age")
    @Schema(name = "Age", minimum = "0", maximum = "120")
    private Integer age;
}
