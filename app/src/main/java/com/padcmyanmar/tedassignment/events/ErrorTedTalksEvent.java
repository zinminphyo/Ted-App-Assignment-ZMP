package com.padcmyanmar.tedassignment.events;

public class ErrorTedTalksEvent {

    private String errorMsg;

    public ErrorTedTalksEvent(String errorMsg) {
        this.errorMsg = errorMsg;

    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
