package cukes.stepdefinitions.support;

import cukes.stepdefinitions.State;
import cukes.stepdefinitions.config.TestConfig;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;



public class DriverManager {
    public RemoteWebDriver driver;
    TestConfig config;

    public DriverManager() {
        config = TestConfig.getInstance();
        
    }

    private Map<String, String> getBrowserCapabilities(){
        return config.loadTestBrowserCapabilities();
    }

    private URL getGridURL() throws MalformedURLException {
        return new URL(config.testProperties.getProperty("selenium.grid.url"));
    }

    public RemoteWebDriver getWebriver() throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities(getBrowserCapabilities());

        driver = new RemoteWebDriver(getGridURL(), capability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public void closeWebriver(){driver.quit();}

    public void takeScreenShot(String screenShotPath){
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        try{FileUtils.copyFile(scrFile, new File(screenShotPath));}
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
