import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginClass{

    public void openLoginPage(WebDriver driver){
        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi");
    }

    public void btnLogin(WebDriver driver, String email, String password){
        driver.findElement(By.xpath("//*[@id=\'L-UserNameField\']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\'L-PasswordField\']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='gg-login-enter']")).click();
        //Assert.assertEquals("Login yapılamadı!", url, driver.getCurrentUrl());
    }
}
