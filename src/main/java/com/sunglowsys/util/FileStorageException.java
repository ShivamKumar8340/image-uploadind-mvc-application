package com.sunglowsys.util;

public class FileStorageException extends RuntimeException{

    private String message;

  public FileStorageException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
