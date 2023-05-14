package quangtester.com.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.keywords.WebUI;

import java.time.Duration;

public class TestFluentWait extends BaseTest {
    @Test
    public void addBrandCMS() {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //Click vào tab menu Product
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();

         /*
            Cách 1 :
        Khai báo WebDriverWait = ExplicitWait
             Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Chờ 30 giây để một phần tử hiện diện trên trang
                .pollingEvery(Duration.ofSeconds(5)) // Và sẽ thực hiện lặp lại mỗi 5 giây nếu chưa tìm thấy phần tử đó
                .ignoring(NoSuchElementException.class);

        Chờ đợi menu Brand đến khi sẵn sàng hiển thị để có thể thao tác được
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Brand']")));
        */

        /*
         Cách 2 : gộp chung
        */
        WebUI.waitForElementVisible_FluentWait(driver,By.xpath("//span[normalize-space()='Brand']"),30,5);

        //Click vào tab menu con Brand sau khi hiển thị thành công
        driver.findElement(By.xpath("//span[normalize-space()='Brand']")).click();

        //Kiểm tra xem có hiển thị chữ "Add new Brand " không
        String headerAddNewBrand = driver.findElement(By.xpath("//div[@class='card-header']/h5")).getText();
        System.out.println("Kết quả hiển thị label :" + headerAddNewBrand);
        Assert.assertEquals(headerAddNewBrand,"Add New Brand");

        //Nhập dữ liệu vào ô search : "BrandTest01" +  thực hiện tìm kiếm
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("BrandTest01", Keys.ENTER);

         /*
         Cách 1 :
            Chờ đợi kết quả tìm kiếm "BrandTest01" đến khi sẵn sàng hiển thị để có thể thao tác được
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody//tr//td[2]")));
        */
         /*
         Cách 2 : gộp chung
        */
        WebUI.waitForElementVisible_FluentWait(driver,By.xpath("//tbody//tr//td[2]"),30,5);

        //Kiểm tra xem có hiển thị đúng kết quả tìm kiếm chưa
        String newBrand = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
        System.out.println("Kết quả tìm kiếm :" + newBrand);
        Assert.assertEquals(newBrand,"BrandTest01");

    }
}
