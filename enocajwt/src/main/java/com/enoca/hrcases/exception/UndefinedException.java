package com.enoca.hrcases.exception;

public class UndefinedException extends RuntimeException {
    public UndefinedException() {
        super("hata");
    }
    public UndefinedException(String msg) {
        super(msg);
    }
}
