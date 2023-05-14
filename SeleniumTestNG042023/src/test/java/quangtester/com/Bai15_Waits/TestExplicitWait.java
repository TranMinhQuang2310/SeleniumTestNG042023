package quangtester.com.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.common.BaseTest_OLD;
import quangtester.com.keywords.WebUI;

import java.time.Duration;

public class TestExplicitWait extends BaseTest {
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Chờ đợi menu Brand đến khi sẵn sàng hiển thị để có thể thao tác được
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Brand']")));
        */

        /*
            Cách 2 : gộp chung
        */
        WebUI.waitForElementVisible(driver,By.xpath("//span[normalize-space()='Brand']"),5);

        /*
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Brand']")));
            => Không dùng được bởi vì chỉ kiểm tra tồn tại trong DOM . Mà UI chưa kịp load => Run sẽ lỗi
        */

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
        WebUI.waitForElementVisible(driver,By.xpath("//tbody//tr//td[2]"),5);

        //Kiểm tra xem có hiển thị đúng kết quả tìm kiếm chưa
        String newBrand = driver.findElement(By.xpath("//tbody//tr//td[2]")).getText();
        System.out.println("Kết quả tìm kiếm :" + newBrand);
        Assert.assertEquals(newBrand,"BrandTest01");



        WebUI.sleep(2);
    }
}
