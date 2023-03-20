package com.example.springmongodbdemo.book.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@Document
@NoArgsConstructor
public class Book {

    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    private String name;

    @Field(targetType = FieldType.OBJECT_ID)
    private String authorId;

    public Book(String name, String authorId) {
        this.name = name;
        this.authorId = authorId;
    }

}
