package cukes.stepdefinitions;

import com.google.inject.Inject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cukes.stepdefinitions.support.PageObject;

public class WebNavigationSteps {
    private final State state;

    @Inject
    public WebNavigationSteps(State state){
        this.state = state;
    }

    @Given("^I navigate \"([^\"]*)\"$")
    public void I_navigate(String pageURL) throws Throwable {
        state.currentPage = new PageObject(state.driver);
        state.currentPage.navigateTo(pageURL);
    }

    @And("^I click on the first link containing \"([^\"]*)\"$")
    public void I_click_on_the_first_link_containing(String name) throws Throwable {
        state.currentPage.clickFirstElementWithText(name);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String searchString) throws Throwable {
        state.currentPage.typeIntoTextFieldWithLabel("q", searchString);
    }
}
