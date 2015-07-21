package cukes.stepdefinitions;

import cukes.stepdefinitions.support.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class State  {
    DriverManager driverManager = new DriverManager();
    RemoteWebDriver driver;

    public State() throws MalformedURLException {
        driver = driverManager.getWebDriver();
    }
}
