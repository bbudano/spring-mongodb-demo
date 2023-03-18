package com.example.springmongodbdemo.author.model;

import org.springframework.data.annotation.Id;

public record Author(@Id String id, String firstName, String lastName) {
}
