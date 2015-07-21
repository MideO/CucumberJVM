package cukes.stepdefinitions;

import com.google.inject.Inject;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertTrue;

public class WebAssertionSteps {
    private final State state;

    @Inject
    public  WebAssertionSteps(State state){
        this.state = state;
    }

    @Then("^I am redirected to the \"([^\"]*)\" github page$")
    public void I_am_redirected_to_the_github_page(String text) throws Throwable {
        assertTrue(state.currentPage.titleIs(text));
    }
}
