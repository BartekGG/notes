package com.nokia.interns.notes.repository;

import com.nokia.interns.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note, Long> {
    List<Note> findByOrderByDateDescIdDesc();
}
