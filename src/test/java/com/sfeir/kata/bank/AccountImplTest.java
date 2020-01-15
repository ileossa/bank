package com.sfeir.kata.bank;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.sfeir.kata.bank.Order.DEPOSIT;
import static com.sfeir.kata.bank.Order.WITHDRAWAL;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountImplTest {

    AccountFactoryHelper account;
    @Mock Event event;

    private UUID uuidUser = UUID.randomUUID();

    @Before
    public void setUp(){
        account = new AccountFactoryHelper(uuidUser);
        // need to set event Object to verify call method
        account.setEvent(event);

    }

    @Test
    public void should_deposti_10_euros_on_my_account(){
        account.deposit(10);
        verify(event, times(1)).publish(uuidUser, DEPOSIT, 10, account.getLocalDateTime());
    }

    @Test
    public void should_withdrawal_10_euros_on_my_account(){
        account.withdrawal(10);
        verify(event, times(1)).publish(uuidUser, WITHDRAWAL, 10, account.getLocalDateTime());
    }


    @Test
    public void should_printStatement(){
        Event.History history = new Event.History(uuidUser, DEPOSIT, 20, account.getLocalDateTime(), 20);
        Map<UUID, List<Event.History>> fakeEventsList = new ConcurrentHashMap<>();
        fakeEventsList.computeIfAbsent(uuidUser, k->new ArrayList<>()).add(history);

        Mockito.when(event.retrieveEvents()).thenReturn(fakeEventsList);
        account.printStatement();
        verify(event, times(1)).retrieveEvents();
    }



}