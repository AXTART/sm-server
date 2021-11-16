package com.secretmessage.smserver.response;

public class StatusResponse implements Response {

    public ResponseStatus status;

    public StatusResponse(ResponseStatus status) {
        this.status = status;
    }

}
