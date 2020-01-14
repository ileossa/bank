package com.sfeir.kata.bank;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Event {

    private Map<UUID, Toto> eventsList = new ConcurrentHashMap<>();

    public void publish(UUID uuid, Order order, int amount, LocalDateTime s){
        System.out.println("call publish");
        Toto toto = new Toto(uuid, order, amount, s);
        eventsList.put(uuid, toto);
    }


    public Map<UUID, Toto> retrieveEvents() {
        return eventsList;
    }

    static class Toto{
        private UUID uuid;
        private Order order;
        private Integer amount;
        private LocalDateTime localDateTime;

        public Toto(UUID uuid, Order order, Integer amount, LocalDateTime localDateTime) {
            this.uuid = uuid;
            this.order = order;
            this.amount = amount;
            this.localDateTime = localDateTime;
        }

        @Override
        public String toString() {
            return "Toto{" +
                    "uuid=" + uuid +
                    ", order=" + order +
                    ", amount=" + amount +
                    ", localDateTime=" + localDateTime +
                    '}';
        }
    }
}
