package cukes.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageObject {
    private WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElementWithText(String text){
        this.driver.findElement(By.name(text)).click();
    }
    public void typeIntoTextFieldWithLabel(String label, String text){;
        this.driver.findElement(By.name(label)).sendKeys(text);
    }
    public boolean containsText(String text) {
        return this.driver.getPageSource().contains(text);
    }
    public boolean titleIs(String text) {
        return this.driver.getTitle().contains(text);
    }

}
