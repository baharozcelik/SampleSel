import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Random;


import static java.lang.Thread.currentThread;

public class SampleTest extends BaseClass {


    @Test
    public void Test1(){

        HomeClass homePage = new HomeClass();
        LoginClass loginPage = new LoginClass();
        CartClass cartPage = new CartClass();

        loginPage.openLoginPage(driver);
        loginPage.btnLogin(driver, "1631014@dogus.edu.tr", "bahar12345" );

        homePage.openHomePage(driver);
        homePage.search(driver, "Bilgisayar");

        homePage.switchPage(driver, "2");

        String Price = homePage.randomSelectAndGetPrice(driver);

        cartPage.addToCart(driver);

        cartPage.navigateToCart(driver);

        cartPage.comparePrice(driver, Price);

        cartPage.increaseQuantity(driver, "2");

        cartPage.checkQuanitiyCount(driver, "2");

        cartPage.deleteProduct(driver);
    }

}

