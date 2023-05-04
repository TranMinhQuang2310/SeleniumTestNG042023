package quangtester.com.Bai11_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;

public class TestHardAssertions extends BaseTest {
    /*
        VD1 : Tạo testcase so sánh giữa kết quả thực tế và mong đợi có bằng với nhau hay không
           => Nếu bằng nhau , in dòng "VD1 Thành công"
          *** Ban đầu điền đại giá trị vô biến expectedTitle , Run xong thấy đoạn Actual thì copy đè vô giá trị vừa điền
    */

    @Test(priority = 1)
    public void TestAssertEquals() {
        driver.get("https://anhtester.com/");

        String actualTitle = driver.getTitle();// Kết quả thực tế lấy từ Automation
        String expectedTitle = "Anh Tester Automation Testing"; //Gán giá trị cứng để điền vô so sánh có giống với giá trị ở thực tế không

        System.out.println("Checking for the tittle");

        //Thực hiện so sánh bằng
        Assert.assertEquals(actualTitle,expectedTitle,"Không bằng nhau");

        //Nếu bằng nhau , in dòng "VD1 Thành công"
        System.out.println("VD1 Thành Công");
    }

     /*
        VD2 : Tạo testcase kiểm tra tittle lấy từ Automation có chứa cụm từ "Anh Tester" không
           => Nếu có chứa , in ra kết quả Tittle
           => Nếu không chứa , in ra true/false
          *** Ban đầu điền đại giá trị vô biến expectedTitle , Run xong thấy đoạn Actual thì copy đè vô giá trị vừa điền
    */
    @Test(priority = 2)
    public void TestAssertTrue() {
        driver.get("https://anhtester.com/");

        String actualTittle = driver.getTitle();
        String expectedTitle = "Anh Tester 123";

        System.out.println("Checking for the tittle");

        //Thực hiện kiểm tra
        Assert.assertTrue(actualTittle.contains(expectedTitle),"Tiêu đề không chứa " + expectedTitle);

        //Nếu có chứa , in dòng "VD2 Thành công"
        System.out.println(actualTittle);
    }

}
