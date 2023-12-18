package com.example.dev_hw19.dto;

import com.example.dev_hw19.entity.Note;
import lombok.Data;

import java.util.Date;

@Data
public class GetNoteResponse {
    private String statusCode;
    private String message;
    private String title;
    private String content;
    private Date createAt;



    public static GetNoteResponse ok(Note note){
        GetNoteResponse responseOk = new GetNoteResponse();
        responseOk.setStatusCode("200 ok");
        responseOk.setMessage("Success");
        responseOk.setTitle(note.getTitle());
        responseOk.setContent(note.getContent());
        responseOk.setCreateAt(note.getCreateAt());
        return responseOk;
    }
    public static GetNoteResponse failed() {
        GetNoteResponse responseFailed = new GetNoteResponse();
        responseFailed.setStatusCode("failed");
        responseFailed.setMessage("Such Note doesn't Exists");
        return responseFailed;
    }
}
