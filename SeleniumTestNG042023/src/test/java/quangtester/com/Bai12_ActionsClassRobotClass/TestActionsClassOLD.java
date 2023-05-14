package quangtester.com.Bai12_ActionsClassRobotClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest_OLD;

public class TestActionsClassOLD extends BaseTest_OLD {
    @Test
    public void TestSendKeys() throws InterruptedException {
        // driver kế thừa từ class BaseTest_OLD
        driver.get("https://www.google.com/");

        //VD1 : Dùng sendKeys và Keys class
        // Bắt xpath của element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));
        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);
        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element,"Anh Tester").sendKeys(Keys.ENTER).build().perform();

        //VD2 : Dùng click
        //Bắt xpath của link web đầu tiên sau khi search thành công
        WebElement tittleResult = driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']"));
        sleep(1);
        //Click vào 1 element
        action.click(tittleResult).perform();

    }

    //VD3 : Dùng Double click (nhấp chuột trái 2 lần) vào Header Page
    @Test
    public void doubleClick() throws InterruptedException {
        // driver kế thừa từ class BaseTest_OLD
        driver.get("https://anhtester.com/");
        sleep(2);

        //Bắt xpath element của Header Page
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Click chuột trái 2 lần vào Header Page
        action.doubleClick(element).perform(); //(Có thể bỏ build do chỉ thao tác 1 lần)
        sleep(2);

    }

    //VD4 : Dùng Context click (nhấp chuột phải 1 lần) vào Header Page
    @Test
    public void contextClick() throws InterruptedException {
        // driver kế thừa từ class BaseTest_OLD
        driver.get("https://anhtester.com/");
        sleep(2);

        //Bắt xpath element của Header Page
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Click chuột phải 1 lần vào Header Page
        action.contextClick(element).perform();//(Có thể bỏ build do chỉ thao tác 1 lần)
        sleep(1);

    }

    //VD5 : Dùng moveToElement (di chuyển trỏ chuột) tới element bị khuất màn hình
    @Test
    public void moveToElement() throws InterruptedException {
        // driver kế thừa từ class BaseTest_OLD
        driver.get("https://anhtester.com/");

        //Bắt xpath element bị khuất màn hình
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Move to element (Di chuyển trỏ chuột tới element)
        action.moveToElement(element).build().perform();
        sleep(2);
    }

    //VD6 : Dùng dragAndDrop để kéo element từ vị trí này sang vị trí kia
    @Test
    public void dragAndDrop() throws InterruptedException {
        // driver kế thừa từ class BaseTest_OLD
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        sleep(2);
        //Bắt xpath element cần kéo (Element which needs to drag) => ở đây lấy card Bank
        WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        //Bắt xpath element vị trí cần thả (// Element on which need to drop.) => ở đây chọn vị trí Account
        WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Gọi hàm dragAndDrop giữa Element
        action.dragAndDrop(From , To).build().perform();
        sleep(2);

        //Ví dụ thêm : Drag and Drop bằng tọa độ (Pixel) => ít dùng
//        WebElement from_5000 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
//        action.dragAndDropBy(from_5000, 168, 40).build().perform();

    }

    //VD7.1 : Dùng KeyUp(thả phím) và KeyDown(nhấn phím) => Nhấn phím SHIFT
    @Test
    public void inputTextUppercase() throws InterruptedException {
        // driver kế thừa từ class BaseTest_OLD
        driver.get("https://www.google.com/");
        sleep(2);

        //Bắt xpath ô search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng KeyDown =>  Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        // Dùng KeyUp => Thả phím SHIFT và nhập text -> Chữ thường
        action.keyDown(element,Keys.SHIFT).sendKeys("anh").keyUp(element,Keys.SHIFT).sendKeys("tester").build().perform();
        sleep(2);
    }

    //VD7.2 : Dùng KeyUp(thả phím) và KeyDown(nhấn phím) => Cuộn lên và xuống trang
    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        driver.get("https://anhtester.com/");

        Actions action = new Actions(driver);
        sleep(1);

        // Scroll down
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        sleep(2);

        //Scroll up
        action.keyUp(Keys.CONTROL).sendKeys(Keys.HOME).perform();
        sleep(2);

    }

    //VD7.3 : Dùng KeyUp(thả phím) và KeyDown(nhấn phím) => Cut & Paste
    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://anhtester.com/blogs");
        sleep(2);

        //Bắt xpath ở ô search course
        WebElement inputCourseElement = driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm khóa học . . .']"));
        //Bắt xpath ở ô search blog
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm bài viết . . .']"));

        Actions action = new Actions(driver);
        sleep(1);
        //Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        sleep(1);

        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        sleep(1);

        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
        sleep(1);

        //click vào ô Blog search
        inputBlogElement.click();
        sleep(1);

        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).keyDown(Keys.ENTER).build().perform();
        sleep(2);


    }

    //VD8 : F5
    //action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();




}
