package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true)
public class dumb {

    @Given("I deposit {int} euros")
    public void i_deposit_euros(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I print the statement of my account")
    public void i_print_the_statement_of_my_account() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("My account as credited of {int} euros")
    public void my_account_as_credited_of_euros(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I deposit {int} euros on my account")
    public void i_deposit_euros_on_my_account(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("print error message and rollback operation")
    public void print_error_message_and_rollback_operation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I have {int} euros on my account")
    public void i_have_euros_on_my_account(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I withdrawal {int} euros on my account")
    public void i_withdrawal_euros_on_my_account(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("statement of my account as {int}")
    public void statement_of_my_account_as(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I have no transaction on my history")
    public void i_have_no_transaction_on_my_history() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I see in my history my operation deposit, with the current date \\(year-mont-day) and {int} euro positive amount.")
    public void i_see_in_my_history_my_operation_deposit_with_the_current_date_year_mont_day_and_euro_positive_amount(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I withdrawal {int} euro on my account")
    public void i_withdrawal_euro_on_my_account(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I see in my history my operation withdrawal, with the current date \\(year-mont-day) and {int} euro negative amount.")
    public void i_see_in_my_history_my_operation_withdrawal_with_the_current_date_year_mont_day_and_euro_negative_amount(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I deposit {int}")
    public void i_deposit(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I withdrawal {int}")
    public void i_withdrawal(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I see in my history {int} transactions\\( date {double} amount), and {int} euros in my bank account.")
    public void i_see_in_my_history_transactions_date_amount_and_euros_in_my_bank_account(Integer int1, Double double1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
