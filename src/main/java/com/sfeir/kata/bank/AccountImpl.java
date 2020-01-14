package com.sfeir.kata.bank;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static com.sfeir.kata.bank.Order.DEPOSIT;
import static com.sfeir.kata.bank.Order.WITHDRAWAL;

public class AccountImpl implements Account {
    protected Event event;
    private final UUID uuid;
    protected final static LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now();

    public AccountImpl(UUID uuidUser) {
        event = new Event();
        this.uuid = uuidUser;
    }

    @Override
    public void deposit(int amount) {
        event.publish(this.uuid, DEPOSIT, amount, LOCAL_DATE_TIME);
    }

    @Override
    public void withdrawal(int amount) {
        event.publish(this.uuid, WITHDRAWAL, amount, LOCAL_DATE_TIME);
    }

    @Override
    public void printStatement() {
        System.out.println("call print");
        Map<UUID, Event.Toto> eventsList = event.getEventsList();
        eventsList.forEach((uuid, event)-> System.out.println(uuid +" -> "+event.toString()));
    }

}
