package com.sfeir.kata.bank;

import java.time.LocalDateTime;
import java.util.UUID;

public class AccountFactoryHelper extends AccountImpl {

    public AccountFactoryHelper(UUID uuidUser) {
        super(uuidUser);
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public LocalDateTime getLocalDateTime(){
        return this.localDateTime;
    }


}
