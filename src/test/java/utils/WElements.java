package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WElements {

    private WebDriver driver;
    private WebDriverWait wait;
    private By locator;
    private List<WebElement> elements;


    private WElements(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private WElements(By locator){
        this();
        this.locator = locator;
        this.elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    public static List<WebElement> $$(By locator){
        return new WElements(locator).elements;
    }

}
