package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    public static ThreadLocal<Browsers> browserNames = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return Driver.getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browsers){
        browserNames.set(browsers); //map gibi düşünelim bu map in içine yani browserNames'in içine browserslardan atadım. set ettim
        if(drivers.get() == null){
            switch (browsers){
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());  //eğer FIREFOX ise drivers a FirefoxDriver ata set et.
                break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver());
                    break;
            }
        }
        return drivers.get();
    }
    public static void quitDriver(){
        if(drivers.get() != null){
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
