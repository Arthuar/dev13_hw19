package com.example.dev_hw19.repository;

import com.example.dev_hw19.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}
