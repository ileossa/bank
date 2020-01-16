package com.sfeir.kata.bank;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static com.sfeir.kata.bank.Order.WITHDRAWAL;

public class Event {

    private Map<UUID, List<History>> eventsList = new ConcurrentHashMap<>();

    public Map<UUID, List<History>> publish(UUID uuid, Order order, int amount, LocalDateTime dateTime){
        History history;
        if(eventsList.isEmpty())
            if(WITHDRAWAL.equals(order))
                history = new History(uuid, order, amount, dateTime, -1*amount);
            else
                history = new History(uuid, order, amount, dateTime, amount);
        else
            history = new History(uuid, order, amount, dateTime, calculate(eventsList));
        eventsList.computeIfAbsent(uuid, k-> new ArrayList<>()).add(history);
        return eventsList;
    }

    public Map<UUID, List<History>> publish(Map<UUID, List<History>> events, UUID uuid, Order order, int amount, LocalDateTime dateTime){
        this.eventsList = events;
        this.publish(uuid, order, amount, dateTime);
        return eventsList;
    }

    /**
     * Calculate balance when publish operation
     * @param eventsList
     * @return balance calculated
     */
    protected int calculate(Map<UUID, List<History>> eventsList){

        return eventsList.values()
                .stream()
                .flatMap(Collection::stream)
                .map(historyEvent -> {
                    if(historyEvent.order.equals(Order.DEPOSIT))
                        historyEvent.balance += historyEvent.amount;
                    else
                        historyEvent.balance -= historyEvent.amount;
                    return historyEvent.balance;
                })
                .reduce((x, y)-> x + y)
                .get();
    }


    public Map<UUID, List<History>> retrieveEvents() {
        return eventsList;
    }

    static class History {
        private UUID uuid;
        private Order order;
        private Integer amount;
        private LocalDateTime localDateTime;
        private Integer balance;

        public History(UUID uuid, Order order, Integer amount, LocalDateTime localDateTime, Integer balance) {
            this.uuid = uuid;
            this.order = order;
            this.amount = amount;
            this.localDateTime = localDateTime;
            this.balance = balance;
        }

        public History(UUID uuid, Order order, Integer amount, LocalDateTime localDateTime) {
            this.uuid = uuid;
            this.order = order;
            this.amount = amount;
            this.localDateTime = localDateTime;
            this.balance = 0;
        }

        @Override
        public String toString() {
            return "History{" +
                    "uuid=" + uuid +
                    ", order=" + order +
                    ", amount=" + amount +
                    ", localDateTime=" + localDateTime +
                    ", balance=" + balance +
                    '}';
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }
    }
}
