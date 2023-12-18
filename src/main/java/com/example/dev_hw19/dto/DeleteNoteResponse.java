package com.example.dev_hw19.dto;

import lombok.Data;

@Data
public class DeleteNoteResponse {
    private Error error;
    private String message;


    public enum Error{
        ok,
        deleteFailed
    }

    public static DeleteNoteResponse okResponse(){
        DeleteNoteResponse response = new DeleteNoteResponse();
        response.setError(Error.ok);
        response.setMessage("Note was deleted successful");
        return response;
    }

    public static DeleteNoteResponse failedResponse(){
        DeleteNoteResponse response = new DeleteNoteResponse();
        response.setError(Error.deleteFailed);
        response.setMessage("Such Note doesn't exists");
        return response;
    }

}
