package stepdef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RelaySteps
{
    private String runnerNumber;
    
    @Before("@First")
    public void startLine() {
        System.out.println("First runner is at start line.");
    }
    
    @Given("^(.*?) runner (has|gets) baton in hand$")
    public void runnerBatonInHand(String runnerNumber, String batonState) {
        this.runnerNumber = runnerNumber;
        System.out.format("%s runner %s baton in hand. \n", runnerNumber, batonState);
    }
    
    @When("^Runner starts running$")
    public void runnerStartsRunning() {
    	System.out.format("%s runner starts running. \n",runnerNumber);
    }
    
    @Then("^Runner runs required (\\d+)$")
    public void runnerRunsRequired(int distance) {
        System.out.format("%s runner reaches %d milestone. \n", runnerNumber, distance);
    }
    
    @After("@Last")
    public void finishLine() {
    	System.out.println("Last runner crosses finish line.");
    }
}
