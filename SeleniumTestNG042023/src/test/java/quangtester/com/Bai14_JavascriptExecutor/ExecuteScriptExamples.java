package quangtester.com.Bai14_JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.keywords.WebUI;

public class ExecuteScriptExamples extends BaseTest {
    @Test
    public void testScript01() {
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");
        WebUI.sleep(5);

          /*
               TH1 : Thực hiện tắt popup thông báo sau đó click vào button 'Copy credentials' => Dùng selenium
          */
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        driver.findElement(By.xpath("//button[@onclick='autoFillCustomer()']")).click();
//        -------------------------------------------------------------------------------------
         /*
               TH2 : Không cần tắt popup mà vẫn click vào button 'Copy credentials' => Dùng javascript
         */

        //Click object với JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;// Khai báo và khởi tạo giá trị cho đối tượng
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@onclick='autoFillCustomer()']")));
        //Tắt popup thông báo
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();


        WebUI.sleep(2);
    }
}
