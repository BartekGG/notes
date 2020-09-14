package com.nokia.interns.notes.controller;

import com.nokia.interns.notes.model.Note;
import com.nokia.interns.notes.model.NoteNotFoundException;
import com.nokia.interns.notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesRestController {
    @Autowired
    private NotesService notesService;

    @GetMapping("/all")
    public List<Note> getAllNotes() {
        return notesService.getAllNotes();
    }

    @GetMapping("/id/{id}")
    public Note getNoteById(@PathVariable String id) throws NumberFormatException, NoteNotFoundException {
        Long convertedId = Long.valueOf(id);
        return notesService.getNoteById(convertedId);
    }
}
