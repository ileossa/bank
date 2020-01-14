package com.sfeir.kata.bank;

import com.sfeir.kata.bank.Event.History;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.sfeir.kata.bank.Order.DEPOSIT;
import static com.sfeir.kata.bank.Order.WITHDRAWAL;

@RunWith(MockitoJUnitRunner.class)
public class EventTest {

    @InjectMocks
    private Event event;
    private Map<UUID, List<History>> baseEvents = new ConcurrentHashMap<>();
    private static final UUID uuid = UUID.randomUUID();
    private LocalDateTime localDateTime ;

    @Before
    public void setUpEach(){
        this.localDateTime = LocalDateTime.now();
        this.baseEvents = new ConcurrentHashMap<>();
    }

    @Test
    public void should_publish_deposit_message(){
        History deposit = new History(uuid, DEPOSIT, 10, localDateTime, 10);
        baseEvents.computeIfAbsent(uuid, k-> new ArrayList<>()).add(deposit);

        event.publish(uuid, DEPOSIT, 10, localDateTime);

        Assertions.assertEquals(baseEvents.toString(), event.retrieveEvents().toString());
    }

    @Test
    public void should_publish_withdrawal_message(){
        History withdrawal = new History(uuid, WITHDRAWAL, 20, localDateTime, -20);
        baseEvents.computeIfAbsent(uuid, k-> new ArrayList<>()).add(withdrawal);

        event.publish(uuid, WITHDRAWAL, 20, localDateTime);

        Assertions.assertEquals(baseEvents.toString(), event.retrieveEvents().toString());
    }

    @Test
    public void should_calculate_balance_with_deposti(){
        History deposit = new History(uuid, DEPOSIT, 100, localDateTime);
        baseEvents.computeIfAbsent(uuid, k-> new ArrayList<>()).add(deposit);

        int balanceCalculated = event.calculate(baseEvents);

        Assertions.assertEquals(100, balanceCalculated);
    }

    @Test
    public void should_calculate_balance_with_deposit_and_withdrawal(){
        History deposit = new History(uuid, DEPOSIT, 100, localDateTime);
        baseEvents.computeIfAbsent(uuid, k-> new ArrayList<>())
                .add(deposit);
        History withdrawal = new History(uuid, WITHDRAWAL, 20, localDateTime);
        baseEvents.computeIfAbsent(uuid, k-> new ArrayList<>())
                .add(withdrawal);

        int balanceCalculated = event.calculate(baseEvents);

        Assertions.assertEquals(80, balanceCalculated);
    }


}