import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class LoginClass{

    public void openLoginPage(WebDriver driver){
        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi");

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        if (driver.getCurrentUrl().contains("https://www.gittigidiyor.com/")) {
            System.out.println("Ana sayfa açıldı.");
        } else {
            throw new WebDriverException("Ana sayfa açılamadı.");
        }
    }

    public void btnLogin(WebDriver driver, String email, String password){
        driver.findElement(By.xpath("//*[@id=\'L-UserNameField\']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\'L-PasswordField\']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='gg-login-enter']")).click();
        assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",driver.getTitle());
        System.out.println("Giriş yapıldı.");
    }
}
