package com.example.springmongodbdemo.author.model;

import java.time.LocalDate;

public record PersonalInfo(String firstName,
                           String lastName,
                           LocalDate dateOfBirth) {
}
