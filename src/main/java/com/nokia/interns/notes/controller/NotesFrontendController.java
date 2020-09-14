package com.nokia.interns.notes.controller;

import com.nokia.interns.notes.model.Note;
import com.nokia.interns.notes.model.NoteNotFoundException;
import com.nokia.interns.notes.model.Priority;
import com.nokia.interns.notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
@RequestMapping("")
public class NotesFrontendController {
    @Autowired
    private NotesService notesService;

    @GetMapping("")
    public String loadNotesTemplate(Model model) {
        model.addAttribute("listOfPriorities", Arrays.asList(Priority.values()));
        model.addAttribute("notes", notesService.getAllNotes());
        return "notes";
    }

    @PostMapping("")
    public String addNote(@RequestParam String title, @RequestParam String contents, @RequestParam String priority) {
        Priority convertedPriority = Priority.valueOf(priority);
        if (convertedPriority == null) convertedPriority = Priority.DEFAULT;
        Note newNote = new Note(0l, title, contents, LocalDate.now(), convertedPriority);
        notesService.addNote(newNote);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable String id) throws NumberFormatException, NoteNotFoundException {
        Long convertedId = Long.valueOf(id);
        notesService.deleteNote(convertedId);
        return "redirect:/";
    }
}