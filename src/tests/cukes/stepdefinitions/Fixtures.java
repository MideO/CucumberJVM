package cukes.stepdefinitions;
import com.google.inject.Inject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.After;

import java.net.MalformedURLException;


public class Fixtures {

    private final State state;

    @Inject
    public Fixtures(State state){
        this.state = state;
    }

    @Before
    private void setUp() throws MalformedURLException {
        state.driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {
            state.driverManager.takeScreenShot("./results/screenShots/"+scenario.toString() + ".png");
        }
        state.driverManager.closeWebDriver();
    }
}
