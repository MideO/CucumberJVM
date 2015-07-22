package cukes.stepdefinitions.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageObject {
    private WebDriver driver;


    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String pageUrl) {
        this.driver.navigate().to(pageUrl);
    }

    public void clickElementWithText(String text) {
        this.driver.findElement(By.name(text)).click();
    }

    public void clickFirstElementWithText(String text) {
        this.driver.findElements(By.partialLinkText(text)).get(0).click();
    }
    public void typeIntoTextFieldWithLabel(String label, String text) {
        this.driver.findElement(By.name(label)).sendKeys(text);
    }
    public void submitRequest(String label) {
        this.driver.findElement(By.name(label)).submit();
    }
    public boolean containsText(String text) {
        return this.driver.getPageSource().contains(text);
    }
    public boolean titleIs(String text) {
        return this.driver.getTitle().contains(text);
    }

}
