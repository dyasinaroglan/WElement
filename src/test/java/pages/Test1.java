package pages;

import org.testng.annotations.Test;
import utils.Conditions;
import utils.Driver;
import utils.WElement;
import static pages.Locators.*;
import static utils.WElement.$;
import static utils.WElement.open;
import static utils.WElements.$$;

public class Test1 {

    @Test
    public void test1(){
        open(url);
        $(lMyAccount).shouldBe(Conditions.VİSİBLE).click();

        $(lLoginLink).shouldBe(Conditions.CLİCKABLE).click();

        $(lemail).sendKeys("testngkurs@gmail.com");

        $(lInputPassword).shouldBe(Conditions.CLİCKABLE).sendKeys("testngkurs").pressEnter();
        $(lSpecials).scrollIntoView().click();

        $$(lproductNames).forEach(e-> System.out.println(e.getText()));

        Driver.quitDriver();
    }

}
