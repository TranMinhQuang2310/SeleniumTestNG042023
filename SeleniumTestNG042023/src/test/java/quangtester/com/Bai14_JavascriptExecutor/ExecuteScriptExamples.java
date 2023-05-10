package quangtester.com.Bai14_JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.keywords.WebUI;

public class ExecuteScriptExamples extends BaseTest {
    @Test
    public void testScript01() {
        driver.get("https://app.hrsale.com/");
        WebUI.sleep(5);

          /*
              VD1 - TH1 : Click vào button 'Super Admin' => Dùng selenium
          */
//        driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();

         /*
               VD1 - TH2 : Click vào button 'Super Admin' => Dùng javascript
         */

        //Click object với JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;// Khai báo và khởi tạo giá trị cho đối tượng
//        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")));

//        -------------------------------------------------------------------------------------
         /*
              VD2 - TH1 : Điền giá trị vào ô input CÓ dùng sendkey() => Dùng selenium
         */
//         js.executeScript("arguments[0].setAttribute('value','frances.burns');",driver.findElement(By.xpath
//                 ("//input[@id='iusername']")));
//         js.executeScript("arguments[0].setAttribute('value','frances.burns');",driver.findElement(By.xpath
//                 ("//input[@id='ipassword']")));
//         driver.findElement(By.xpath("//button[@type='submit']")).click();

         /*
              VD2 - TH3 : Điền giá trị vào ô input CÓ dùng sendkey() nhưng để giá trị nhập ra bên ngoài => Dùng selenium
         */

         js.executeScript("arguments[0].setAttribute('value',arguments[1]);",driver.findElement
                 (By.xpath("//input[@id='iusername']")),"frances.burns");
         js.executeScript("arguments[0].setAttribute('value',arguments[1]);",driver.findElement
                 (By.xpath("//input[@id='ipassword']")),"frances.burns");
         driver.findElement(By.xpath("//button[@type='submit']")).click();


         /*
              VD2 - TH2 : Điền giá trị vào ô input mà KHÔNG dùng sendkey() => Dùng javascript
         */
//        js.executeScript("document.getElementById('email').setAttribute('value','frances.burns');");
//        js.executeScript("document.getElementById('password').setAttribute('value','frances.burns');");


//        -------------------------------------------------------------------------------------

         /*
              VD3 : Thực hiện Cuộn chuột => Dùng selenium
              (*Lưu ý : ở hàm script, true có nghĩa là cuộn xuống mé trên ,false nghĩa là cuộn xuống mé dưới)
         */
        WebElement tickets = driver.findElement(By.xpath("//div[@class='col-sm-6 card-body br']//span[normalize-space()='Tickets']"));
        WebUI.sleep(3);
        js.executeScript("arguments[0].scrollIntoView(false);", tickets);

        WebUI.sleep(3);
    }

    @Test
    public void testScript02() {
        driver.get("https://app.hrsale.com/");

        //Khai báo và khởi tạo giá trị đối tượng
        JavascriptExecutor js = (JavascriptExecutor) driver;

        /*
              VD1 : Để tạo Alert
         */
        js.executeScript("alert('Welcome To Anh Tester - Automation Testing');");


        WebUI.sleep(3);
    }
}
