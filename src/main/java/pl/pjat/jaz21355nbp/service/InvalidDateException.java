package pl.pjat.jaz21355nbp.service;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String date){
        super(date + " is not valid");
    }
}

