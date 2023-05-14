package quangtester.com.Bai10_AnnotationTestNG;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import quangtester.com.common.BaseTest_OLD;

public class LoginCMS extends BaseTest_OLD {
    //Tạo 1 testcase
    @Test(priority = 2 ,description = "Login CMS") //priority là độ ưu tiên
    public void testLoginCMS() throws InterruptedException {
        System.out.println("Run Test CMS");
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//button[normalize-space() ='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space() ='Login']")).click();
        Thread.sleep(2);
    }

    @Test(priority = 1 , description = "Login AnhTester")//priority là độ ưu tiên
    public void testAnhTesterBlog() throws InterruptedException {
        System.out.println("Run Test AnhTester");
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2);
    }

}
