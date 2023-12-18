package com.example.dev_hw19.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateNoteEntity {
    private long id;
    private Status status;

    public enum Status{
        ok,
        badTitle,
        badContent,
        notExist
    }
}
