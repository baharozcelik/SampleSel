import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class CartClass {

    public void navigateToCart(WebDriver driver){
        driver.navigate().to("https://www.gittigidiyor.com/sepetim");
    }

    public void addToCart(WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        driver.findElement(By.xpath("/html//button[@id='add-to-basket']")).click();
    }

    public void comparePrice(WebDriver driver, String price){
        WebElement productPriceInBasket = driver.findElement(By.xpath(".//*[@id='cart-price-container']/div[3]/p"));
        String basketPrice = productPriceInBasket.getText();
        Assert.assertEquals(price, basketPrice);
        System.out.println("Ürün fiyatı ile sepet fiyatı aynıdır ve " + basketPrice + "'dir.");
    }

    public void increaseQuantity(WebDriver driver, String quantity)   {
        WebElement productQuantity = driver.findElement(By.xpath(
                "//body/div[@id='main-content']/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/div[4]/div[1]/div[2]/select[1]"));
        productQuantity.click();
        productQuantity.sendKeys(quantity);
        productQuantity.sendKeys(Keys.ENTER);
    }

    public void checkQuantityCount(WebDriver driver, String count){
        WebElement productCount = driver.findElement(By.xpath(
                "//*[@id=\'submit-cart\']/div/div[2]/div[3]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[1]"));
        System.out.println("Sepette " + count + " adet ürün bulunmaktadır.");
        //}
    }

    public void deleteProduct(WebDriver driver) {
        driver.findElement(By.xpath(
                "/html//div[@id='cart-items-container']/div[@class='products-container']/div/div//div[@class='row']/a[@title='Sil']/i[@class='gg-icon gg-icon-bin-medium']"))
                .click();
        System.out.println("Sepetteki ürünler silindi.");

    }
}
