package com.example.springmongodbdemo.author.model;

import com.example.springmongodbdemo.book.model.Book;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Author {

    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    private PersonalInfo personalInfo;

    @ReadOnlyProperty
    @DocumentReference(lookup="{'authorId':?#{#self._id} }")
    private List<Book> books;

    public Author(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

}
