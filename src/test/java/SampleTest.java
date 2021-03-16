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

public class SampleTest {


    @Test
    public void Test1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://gittigidiyor.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        if (driver.getCurrentUrl().contains("https://www.gittigidiyor.com/")) {
            System.out.println("Gittigidiyor sayfasina giris yapildi");
            System.out.println("-----------------------------");
        } else {
            throw new WebDriverException("Gittigidiyor sayfasi acilamadi");
        }

        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi");
        driver.findElement(By.xpath("//*[@id=\'L-UserNameField\']")).sendKeys("1631014@dogus.edu.tr");
        driver.findElement(By.xpath("//*[@id=\'L-PasswordField\']")).sendKeys("bahar12345");
        driver.findElement(By.xpath("//*[@id='gg-login-enter']")).click();
        //Assert.assertEquals("Login yapılamadı!", url, driver.getCurrentUrl());

        driver.findElement(By.xpath("//input[@data-cy='header-search-input']")).click(); //Finding the search box in Home Page
        driver.findElement(By.xpath("//input[@data-cy='header-search-input']")).sendKeys("Bilgisayar");

        driver.findElement(By.xpath("//button[@data-cy='search-find-button']")).click();

        driver.navigate().to("https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2");

        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        driver.findElement(By.cssSelector(
                "body.desktop:nth-child(2) div.gray-content:nth-child(5) div.container:nth-child(8) div.clearfix div.ggfound-x-times.padding-none.mrb10.gg-uw-19.gg-w-18.gg-d-18.gg-t-24.gg-m-24.padding-none div.blueWrapper.clearfix:nth-child(3) div.clearfix:nth-child(4) ul.catalog-view.clearfix.products-container:nth-child(1) li.gg-uw-6.gg-w-8.gg-d-8.gg-t-8.gg-m-24.gg-mw-12.catalog-seem-cell.srp-item-list.browser:nth-child(2) a.product-link div.cell-border-css div.product-info-con.clearfix div.gg-w-24.gg-d-24.gg-t-24.gg-m-24.pl0.pr0.product-info-details:nth-child(1) div.gg-w-24.gg-d-24.gg-t-24.gg-m-24.product-title-info:nth-child(1) h3.product-title > span:nth-child(1)"))
                .click();
        WebElement productPriceInDetails = driver.findElement(By.xpath("/html//div[@id='sp-price-lowPrice']"));
        String listPrice = productPriceInDetails.getText();

//			Add to basket
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        driver.findElement(By.xpath("/html//button[@id='add-to-basket']")).click();

        driver.navigate().to("https://www.gittigidiyor.com/sepetim");

        //			Check the product price
        WebElement productPriceInBasket = driver.findElement(By.xpath(".//*[@id='cart-price-container']/div[3]/p"));
        String basketPrice = productPriceInBasket.getText();
        Assert.assertEquals(listPrice, basketPrice);
        System.out.println("Urunun listelenen fiyati ile sepetteki fiyati esittir ve " + basketPrice + "'dir.");
        System.out.println("-----------------------------");

//			Product Quantity
        WebElement productQuantity = driver.findElement(By.xpath(
                "//body/div[@id='main-content']/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[4]/div[1]/div[2]/select[1]"));
        productQuantity.click();
        productQuantity.sendKeys("2");
        productQuantity.sendKeys(Keys.ENTER);

        //	 		Check the product count
        WebElement productCount = driver.findElement(By.xpath(
                "//*[@id=\'submit-cart\']/div/div[2]/div[3]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[1]"));
        System.out.println(productCount.getText());
        System.out.println("-----------------------------");

        if (productCount.getText().contains("2 Adet")) {
            System.out.println("Sepetteki urun adedi 2'dir.");
            System.out.println("-----------------------------");

        } else {
            System.out.println("Sepetteki urun adedi 2 degildir.");
        }
//			Delete the item
        driver.findElement(By.xpath(
                "/html//div[@id='cart-items-container']/div[@class='products-container']/div/div//div[@class='row']/a[@title='Sil']/i[@class='gg-icon gg-icon-bin-medium']"))
                .click();

//			Close the window
        driver.quit();

        System.out.println("Hello folks!");
    }

}

