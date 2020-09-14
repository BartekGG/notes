package com.nokia.interns.notes.service;

import com.nokia.interns.notes.model.Note;
import com.nokia.interns.notes.model.Priority;
import com.nokia.interns.notes.repository.NotesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
@Slf4j
public class DummyDataService {
    @Autowired
    private NotesRepository notesRepository;

    @PostConstruct
    public void init() {
        Note n1 = new Note(0l, "Notatka testowa", "Oto nasza pierwsza notatka!", LocalDate.now(), Priority.DEFAULT);
        Note n2 = new Note(0l, "Lista zakupów", "- mleko\n- ser\n- kawa", LocalDate.now(), Priority.LOW);
        Note n3 = new Note(0l, null, "Ważna notatka bez tytułu", LocalDate.now(), Priority.HIGH);

        n1 = notesRepository.save(n1);
        n2 = notesRepository.save(n2);
        n3 = notesRepository.save(n3);

        log.info("Dodano trzy notatki:\n1. {}\n2. {}\n3. {}", n1, n2, n3);
    }
}
