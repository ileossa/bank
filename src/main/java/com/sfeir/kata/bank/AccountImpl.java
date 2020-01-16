package com.sfeir.kata.bank;

import com.sfeir.kata.bank.Event.History;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.sfeir.kata.bank.Order.DEPOSIT;
import static com.sfeir.kata.bank.Order.WITHDRAWAL;

public class AccountImpl implements Account {
    protected Event event;
    private final UUID uuid;
    protected LocalDateTime localDateTime;
    private Map<UUID, List<History>> eventsHistory;

    public AccountImpl(UUID uuidUser) {
        event = new Event();
        this.uuid = uuidUser;
    }

    @Override
    public void deposit(int amount) {
        localDateTime = LocalDateTime.now();
         eventsHistory = event.publish(eventsHistory, this.uuid, DEPOSIT, amount, localDateTime);
    }

    @Override
    public void withdrawal(int amount) {
        localDateTime = LocalDateTime.now();
        eventsHistory = event.publish(eventsHistory, this.uuid, WITHDRAWAL, amount, localDateTime);
    }

    @Override
    public void printStatement() {
        Map<UUID, List<History>> eventsList = event.retrieveEvents();
        eventsList.forEach((uuid, event)-> System.out.println(event.toString()));
    }

}