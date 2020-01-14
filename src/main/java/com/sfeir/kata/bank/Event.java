package com.sfeir.kata.bank;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Event {

    private Map<UUID, History> eventsList = new ConcurrentHashMap<>();

    public void publish(UUID uuid, Order order, int amount, LocalDateTime dateTime){
        System.out.println("call publish");
        History history = new History(uuid, order, amount, dateTime);
        eventsList.put(uuid, history);
    }

    /**
     * Calculate balance when publish operation
     * @param eventsList
     * @return
     */
    private int calculate(Map<UUID, History> eventsList){
        return 1;
    }


    public Map<UUID, History> retrieveEvents() {
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
            return "Toto{" +
                    "uuid=" + uuid +
                    ", order=" + order +
                    ", amount=" + amount +
                    ", localDateTime=" + localDateTime +
                    ", balance=" + balance +
                    '}';
        }
    }
}
