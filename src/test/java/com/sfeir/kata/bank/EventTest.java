package com.sfeir.kata.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.sfeir.kata.bank.Order.DEPOSIT;
import static com.sfeir.kata.bank.Order.WITHDRAWAL;

@RunWith(MockitoJUnitRunner.class)
public class EventTest {

    @InjectMocks
    private Event event;
    private Map<UUID, Event.History> baseEvents;
    private static final UUID uuid = UUID.randomUUID();
    private LocalDateTime localDateTime ;

    @Before
    public void setUpEach(){
        this.localDateTime = LocalDateTime.now();
        this.baseEvents = new ConcurrentHashMap<>();
    }

    @Test
    public void should_publish_deposit_message(){
        baseEvents.put(uuid, new Event.History(uuid, DEPOSIT, 10, localDateTime));

        event.publish(uuid, DEPOSIT, 10, localDateTime);

        Assertions.assertEquals(baseEvents.toString(), event.retrieveEvents().toString());
    }

    @Test
    public void should_publish_withdrawal_message(){
        baseEvents.put(uuid, new Event.History(uuid, WITHDRAWAL, 20, localDateTime));

        event.publish(uuid, WITHDRAWAL, 20, localDateTime);

        Assertions.assertEquals(baseEvents.toString(), event.retrieveEvents().toString());
    }

    @Test
    public void should_calculate_balance(){
        baseEvents.put(uuid, new Event.History(uuid, DEPOSIT, 100, localDateTime));
//        baseEvents.put(uuid, new Event.History(uuid, WITHDRAWAL, 20, localDateTime));

        int balanceCalculated = event.calculate(baseEvents);

        Assertions.assertEquals(100, balanceCalculated);
    }


}