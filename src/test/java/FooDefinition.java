import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static org.junit.Assert.*;

public class FooDefinition {
    @Given("I have a pre-condition")
    public void iHaveAPreCondition() {
        //Assert.fail();
        Assert.assertEquals("Comparing the strings: ","automation","automation");
    }

    @When("I perform some action")
    public void iPerformSomeAction() {
        //code here
        Assert.fail();
    }

    @Then("I should some result")
    public void iShouldSomeResult() {
        //code here
    }

    @Given("there are {int} cucumbers")
    public void thereAreStartCucumbers(int i0) {
       // assertEquals(i0,0);
        System.out.println(i0);
    }

    @When("I eat {int} cucumbers")
    public void iEatEatCucumbers(int param0) {
        System.out.println(param0);
    }

    @Then("I should have {int} cucumbers")
    public void iShouldHaveLeftCucumbers(int i0) {
        System.out.println(i0);
    }

    @Given("I have a session today")
    public void iHaveASessionToday() {
    }

    @When("I start session link {word}")
    public void iStartSessionLinkLink(String i0) {
    }

    @And("I join the session")
    public void iJoinTheSession() {
    }

    @Then("I should see session is started successfully")
    public void iShouldSeeSessionIsStartedSuccessfully() {
    }

    @Given("website is up and running")
    public void websiteIsUpAndRunning() {
    }

    @When("I open a website in browser")
    public void iOpenAWebsiteInBrowser() {
    }

    @And("I enter a city name as {string}")
    public void iEnterACityNameAs(String arg0) {
    }

    @When("I hit enter key from keyboard")
    public void iHitEnterKeyFromKeyboard() {
    }

    @Then("I should see list of hotels for {string}")
    public void iShouldSeeListOfHotelsFor(String arg0) {
    }


}
