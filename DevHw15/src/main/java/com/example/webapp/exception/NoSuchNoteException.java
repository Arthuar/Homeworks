package com.example.webapp.exception;

public class NoSuchNoteException extends RuntimeException{
    public NoSuchNoteException(){
        super("it is no such note");
    }
}
