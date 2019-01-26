import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    @Test
    public void checkGoogle() {

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http:/www.google.com");

            List<String> strings = new ArrayList<String>();
            for (String s : driver.getWindowHandles()) {
                strings.add(s);

            }

            driver.switchTo().window(strings.get(1));


            WebElement element = driver.findElement(By.xpath("//*[@alt='Google']"));
            boolean bool = element.isDisplayed();
            System.out.println(bool);
            Assert.assertTrue(bool, "Element is displayed");

        } finally {

            driver.quit();
        }
    }


    @Test
    public void testExplicitWait() {
        WebDriver driver = new ChromeDriver();

        new WebDriverWait(driver, 10)
                .until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        return webDriver.findElement(By.xpath("//div")).getText().contains("Success");
                    }
                });
    }

}



