package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitElementAndClick(By elemento){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(elemento))).click();
    }

    public void waitElementAndSendkeys(By elemento, String keys){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(elemento))).sendKeys(keys);
    }
}
