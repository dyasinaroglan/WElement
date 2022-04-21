package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WElement {

    private WebDriver driver;
    private WebDriverWait wait;
    private By locator;
    private WebElement element;


    private WElement(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WElement(By locator){
        this();  //class' ifade ediyor.  this() methot demektir. ve bu class'ın methodu parametresi boş olan constructur'dır. yani driver
        //tanımladığımız constructor.
        // this() tanımlamasaydık yukarıda driver çalışmayacaktı.
        this.locator = locator;  //bu nesneyi ifade ediyor.
        this.element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // elemente çevirdik.WebElement element; e attık
        //this kullanmamız da gerekmez. parametre olarak element almamış zaten. otomatikman yukarıdaki elementi görecek
    }

    public static WElement $(By locator){
        return new WElement(locator);
    }
    private WElement(WebElement element){
        this();
        this.element = element;  //@FindBy ile kullanıyorsam
    }
    public void openUrl(String url){
        driver.get(url);
    }
    public static void open(String url){
        new WElement().openUrl(url);
        //boş constructor lı nesneyi oluşturduğumda üstteki driver methotlu olan constructur çalışacak sonra openUrl() methodu çalışacak.
    }
    public void click(){
        element.click();
    }
    public WElement sendKeys(String str){
        element.sendKeys(str);
        return this;
        //class' return ettiği için artık return edilen class daki methotları kullanabiliyorum
    }
    public void clear(){
        element.clear();
    }

    public void pressEnter(){
        element.sendKeys(Keys.ENTER);
    }
    public WElement scrollIntoView(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        return this;
    }
    public WElement shouldBe(Conditions conditions){
        switch (conditions){
            case EXİST:
            case VİSİBLE:
            case APPEAR:
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case CLİCKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;

        }
        return this;
    }
}
