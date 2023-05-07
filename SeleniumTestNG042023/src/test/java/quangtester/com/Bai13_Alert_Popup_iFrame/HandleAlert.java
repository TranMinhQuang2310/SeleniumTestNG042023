package quangtester.com.Bai13_Alert_Popup_iFrame;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;

public class HandleAlert extends BaseTest {

    //VD1 : Test alert cơ bản
    @Test
    public void TestAlert01() {
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        //Lấy xpath form nhập customer ID
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // Khai báo chuyển hướng đến Alert với đối tượng
        Alert alert = driver.switchTo().alert();

        //Get message trên alert
        String alertMessage = driver.switchTo().alert().getText();

        //Hiển thị alert message
        System.out.println(alertMessage);
        sleep(2);

        // accept() = nhấn Ok button
            // Cách 1:  driver.switchTo().alert().accept();
            // Cách 2 :
        alert.accept();
        sleep(2);

        // Get lại message trên alert sau khi accept
        String alertMessageAccepted = driver.switchTo().alert().getText();
        //Hiển thị alert message
        System.out.println(alertMessageAccepted);
        sleep(1);

        //Nhấn Cancel button
        //alert.dismiss();
    }

    //VD2 : sendkeys áp dụng softAssertion
    @Test
    public void TestAlert02() {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        sleep(2);

        //Click button Alert with Textbox
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        sleep(2);

        //Click "button to demonstrate the prompt box"
        driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
        sleep(2);

        //Nhấn sendKeys vào ô text
        driver.switchTo().alert().sendKeys("Quang");
        sleep(2);

        // accept() = nhấn Ok button
        driver.switchTo().alert().accept();
        sleep(2);

        //Kiểm tra sau khi nhấn Ok thì có CHỨA tên vừa nhập vào hay không
        WebElement result = driver.findElement(By.xpath("//p[@id='demo1']"));
        Assert.assertTrue(result.getText().contains("Quang"),"Không chứa giá trị điền vào ô textbox");
        //Nếu kiểm tra có chứa
        System.out.println("Giá trị là :" + result.getText());
    }

    //VD3 : sendkeys áp dụng hardAssertion
    @Test
    public void TestAlert03() {
        driver.get("https://demoqa.com/alerts");
        sleep(2);

        //Bắt xpath ô click me
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        sleep(2);

        //Nhấn sendKeys vào ô text
        driver.switchTo().alert().sendKeys("Quang123");
        sleep(2);

        //Nhấn Ok
        driver.switchTo().alert().accept();
        sleep(2);

        //Kiểm tra sau khi nhấn Ok thì có CHỨA tên vừa nhập vào hay không
        String value = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
        System.out.println(value);
        Assert.assertTrue(value.contains("Quang123"),"Không chứa Text sendKeys");
        sleep(1);

    }

}
