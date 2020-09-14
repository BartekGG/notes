package com.nokia.interns.notes.service;

import com.nokia.interns.notes.model.Note;
import com.nokia.interns.notes.model.NoteNotFoundException;
import com.nokia.interns.notes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    private NotesRepository notesRepository;

    public List<Note> getAllNotes() {
        return notesRepository.findByOrderByDateDescIdDesc();
    }

    public Note getNoteById(Long id) throws NoteNotFoundException {
        if (!notesRepository.existsById(id)) throw new NoteNotFoundException(id);
        else return notesRepository.getOne(id);
    }

    public Note addNote(Note note) {
        return notesRepository.save(note);
    }

    public Note deleteNote(Long id) throws NoteNotFoundException {
        if (!notesRepository.existsById(id)) throw new NoteNotFoundException(id);
        else {
            Note noteToRemove = notesRepository.getOne(id);
            notesRepository.deleteById(id);
            return noteToRemove;
        }
    }
}
