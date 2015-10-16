package cukes.stepdefinitions;

import com.google.inject.Inject;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

import static junit.framework.TestCase.assertTrue;

public class WebAssertionSteps {
    private final State state;

    @Inject
    public  WebAssertionSteps(State state){
        this.state = state;
    }

    @Then("^I should be redirected to the \"([^\"]*)\" github page$")
    public void I_am_redirected_to_the_github_page(String text) throws Throwable {
        assertTrue(state.currentPage.titleIs(text));
        Assert.assertTrue(state.currentPage.containsText(text));
    }
}
