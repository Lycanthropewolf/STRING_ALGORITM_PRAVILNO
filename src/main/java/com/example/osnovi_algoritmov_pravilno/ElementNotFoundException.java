package com.example.osnovi_algoritmov_pravilno;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(String element) {
        super(String.format("Element has not be found: %s",element));
    }
}
