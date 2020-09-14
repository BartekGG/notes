package com.nokia.interns.notes.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nokia.interns.notes.serializer.NoteSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notes")
@JsonSerialize(using = NoteSerializer.class)
public class Note {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @NotNull
    private String contents;

    @NotNull
    private LocalDate date;

    @Enumerated
    private Priority priority;
}
