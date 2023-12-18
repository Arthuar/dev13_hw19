package com.example.dev_hw19.controller;

import com.example.dev_hw19.dto.CreateNoteEntity;
import com.example.dev_hw19.dto.DeleteNoteResponse;
import com.example.dev_hw19.dto.GetNoteResponse;
import com.example.dev_hw19.entity.Note;
import com.example.dev_hw19.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoteController {
    private final NoteService noteService;
    @GetMapping
    public List<Note> getAllNotes(){
        return noteService.allNotes();
    }
    @GetMapping("/{id}")
    public GetNoteResponse getNoteById(@PathVariable("id") Long id){
        return noteService.getNoteForApi(id);
    }
    @PostMapping("/create")
    public CreateNoteEntity createNote(@RequestBody Note note){
        return noteService.addNote(note);
    }
    @PostMapping("/update")
    public CreateNoteEntity updateNote(@RequestBody Note note){
        return noteService.updateNote(note);
    }
    @PostMapping("/delete/{id}")
    public DeleteNoteResponse deleteNote(@PathVariable("id") long id){
        return noteService.deleteNote(id);
    }
}
