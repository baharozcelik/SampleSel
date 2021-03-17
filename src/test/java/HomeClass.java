import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class HomeClass {

    public void openHomePage(WebDriver driver){
        driver.navigate().to("https://www.gittigidiyor.com/");
    }

    public void search(WebDriver driver, String searchText){
        driver.findElement(By.xpath("//input[@data-cy='header-search-input']")).click(); //Finding the search box in Home Page
        driver.findElement(By.xpath("//input[@data-cy='header-search-input']")).sendKeys(searchText);

        driver.findElement(By.xpath("//button[@data-cy='search-find-button']")).click();
    }

    public void switchPage(WebDriver driver, String pageNumber){
        driver.navigate().to("https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=" + pageNumber);
        assertEquals("Bilgisayar - GittiGidiyor - 2/100",driver.getTitle());
        System.out.println("2. sayfa açıldı.");

    }

    public String randomSelectAndGetPrice(WebDriver driver){

        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");

        driver.findElement(By.cssSelector(
                "body.desktop:nth-child(2) div.gray-content:nth-child(5) div.container:nth-child(8) div.clearfix div.ggfound-x-times.padding-none.mrb10.gg-uw-19.gg-w-18.gg-d-18.gg-t-24.gg-m-24.padding-none div.blueWrapper.clearfix:nth-child(3) div.clearfix:nth-child(4) ul.catalog-view.clearfix.products-container:nth-child(1) li.gg-uw-6.gg-w-8.gg-d-8.gg-t-8.gg-m-24.gg-mw-12.catalog-seem-cell.srp-item-list.browser:nth-child(2) a.product-link div.cell-border-css div.product-info-con.clearfix div.gg-w-24.gg-d-24.gg-t-24.gg-m-24.pl0.pr0.product-info-details:nth-child(1) div.gg-w-24.gg-d-24.gg-t-24.gg-m-24.product-title-info:nth-child(1) h3.product-title > span:nth-child(1)"))
                .click();

        WebElement productPriceInDetails = driver.findElement(By.xpath("/html//div[@id='sp-price-lowPrice']"));
        String listPrice = productPriceInDetails.getText();

        return listPrice;
    }
}
