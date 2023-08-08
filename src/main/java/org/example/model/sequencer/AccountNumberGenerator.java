package org.example.model.sequencer;

public class AccountNumberGenerator {

    private static long accountNumberCounter = 0;

    public static long generateNextAccountNumber(){
        return ++accountNumberCounter;
    }

}
