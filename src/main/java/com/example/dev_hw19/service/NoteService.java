package com.example.dev_hw19.service;

import com.example.dev_hw19.dto.CreateNoteEntity;
import com.example.dev_hw19.dto.DeleteNoteResponse;
import com.example.dev_hw19.dto.GetNoteResponse;
import com.example.dev_hw19.entity.Note;
import com.example.dev_hw19.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final static int MAX_TITLE_LENGTH = 100;
    private final static int MAX_CONTENT_LENGTH = 1000;
    private final NoteRepository noteRepository;
    public CreateNoteEntity addNote(Note note){
        note.setCreateAt(new Date());
        if(note.getTitle()==null || note.getTitle().length()>MAX_TITLE_LENGTH){
            return CreateNoteEntity.builder().status(CreateNoteEntity.Status.badTitle).id(-1).build();
        }if(note.getContent()==null || note.getContent().length()>MAX_CONTENT_LENGTH){
            return CreateNoteEntity.builder().status(CreateNoteEntity.Status.badContent).id(-1).build();
        }
        noteRepository.save(note);
        return CreateNoteEntity.builder().status(CreateNoteEntity.Status.ok).id(note.getId()).build();
    }
    public List<Note> allNotes(){
        return noteRepository.findAll();
    }
    public Note getNote(Long id){
        return noteRepository.findById(id).orElseThrow();
    }
    public GetNoteResponse getNoteForApi(long id){
        if(noteRepository.findById(id).isEmpty()){
            return GetNoteResponse.failed();
        }
        return GetNoteResponse.ok(getNote(id));
    }

    public CreateNoteEntity updateNote(Note note){
        if(noteRepository.findById(note.getId()).isEmpty()){
            return CreateNoteEntity.builder().status(CreateNoteEntity.Status.notExist).id(note.getId()).build();
        }
        return addNote(note);
    }
    public DeleteNoteResponse deleteNote(Long id){
        if (noteRepository.findById(id).isEmpty()){
            return DeleteNoteResponse.failedResponse();
        }
        noteRepository.deleteById(id);
        return DeleteNoteResponse.okResponse();
    }
}
