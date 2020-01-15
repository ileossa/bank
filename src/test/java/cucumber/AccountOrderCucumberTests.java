package cucumber;

import com.sfeir.kata.bank.Account;
import com.sfeir.kata.bank.AccountImpl;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;


public class AccountOrderCucumberTests {

    private Account account;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp(){
        this.account = new AccountImpl(UUID.randomUUID());
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore(){
        System.setOut(originalOut);
    }


    @Given("I have no money")
    public void i_have_no_money() {

    }

    @When("I want to make a deposit in my bank")
    public void i_want_to_make_a_deposit_in_my_bank() {
        account.deposit(10);
    }

    @Given("I have {int} money")
    public void i_have_money(Integer int1) {
        Assertions.assertEquals(int1, outContent.toString());
    }

    @Given("I have {int} money on my bank")
    public void i_have_money_on_my_bank(Integer int1) {
        account.deposit(int1);
    }

    @When("I want to make a {int} withdrawal from my bank")
    public void i_want_to_make_a_withdrawal_from_my_bank(Integer int1) {
        account.withdrawal(int1);
    }

    @Given("I have make deposit of {int} and withdrawal of {int} on my bank")
    public void i_have_make_deposit_of_and_withdrawal_of_on_my_bank(Integer int1, Integer int2) {
        account.deposit(int1);
        account.withdrawal(int2);
    }

    @When("I want to see the history \\(operation, date, amount, balance) of my operations")
    public void i_want_to_see_the_history_operation_date_amount_balance_of_my_operations() {
        account.printStatement();
    }

    @Then("I print history")
    public void i_print_history() {
        Assertions.assertEquals(10, outContent.toString());
    }

}
