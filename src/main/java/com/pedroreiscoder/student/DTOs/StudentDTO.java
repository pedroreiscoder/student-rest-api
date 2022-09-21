package com.pedroreiscoder.student.DTOs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentDTO {

    @NotBlank
    @Size(max = 100)
    private String name;

    @Size(max = 50)
    private String email;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
