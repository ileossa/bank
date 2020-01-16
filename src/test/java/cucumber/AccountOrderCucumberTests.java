package cucumber;

import com.sfeir.kata.bank.AccountFactoryHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.UUID;


public class AccountOrderCucumberTests {

    private UUID uuid = UUID.randomUUID();
    private AccountFactoryHelper account;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp(){
        this.account = new AccountFactoryHelper(uuid);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restore(){
        System.setOut(originalOut);
    }


    @Given("I have no money")
    public void i_have_no_money() {
        account.printStatement();
    }

    @When("I want to make a deposit {int} in my bank")
    public void i_want_to_make_a_deposit_in_my_bank(Integer int1) {
        account.deposit(int1);
    }

    @Given("I have {int} money")
    public void i_have_money(Integer int1) {
        Assertions.assertEquals(int1, outContent.toString());
    }

    @Given("I have {int} money on my bank")
    public void i_have_money_on_my_bank(Integer int1) {
        account.deposit(int1);
    }

    @When("I want to make a withdrawal {int} from my bank")
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

    /**
     *   Example informations expected
     *   |  ORDER   |  AMOUNT  | BALANCE
     *   | DEPOSIT  |   10     |  10
     *   |WITHDRAWAL|   5      | 15
     */
    @Then("I print history")
    public void i_print_history() {



        Assertions.assertTrue(isContains(outContent.toString(), "DEPOSIT"));// ORDER
        Assertions.assertTrue(isContains(outContent.toString(), "10"));    // AMOUNT
        Assertions.assertTrue(isContains(outContent.toString(), "20"));    // BALANCE

        Assertions.assertTrue(isContains(outContent.toString(), "WITHDRAWAL")); // ORDER
        Assertions.assertTrue(isContains(outContent.toString(), "5")); // AMOUNT
        Assertions.assertTrue(isContains(outContent.toString(), "15")); // BALANCE

    }

    private boolean isContains(String actual, String expected) {
        return Arrays.asList(expected.replaceAll("[^a-zA-Z0-9--:]", ";").split(";")).contains(expected);
    }


}
