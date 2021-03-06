import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class LesTest {

    @Test
    public void first() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        element.click();
        WebElement deleteButton = driver.findElement(By.xpath("//*[@class=\"added-manually\"]"));

        Assert.assertEquals(deleteButton.getText(), "Delete");

    }

    @Test
    public void first2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
        element1.click();
        WebElement Ops2 = driver.findElement(By.xpath("//*//*[@id=\"dropdown\"]/option[3]"));
        Ops2.click();
        Assert.assertEquals(Ops2.getText(), "Option 2");
    }

    @Test
    public void first3() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://onliner.by/");
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/header/div[2]/div/nav/ul[1]/li[1]/a[2]/span"));
        element3.click();
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul"));
        list.forEach(item ->
                System.out.println(item.getText()));

    }

    @Test
    public void first4() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://onliner.by/");
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"fast-search\"]/form/input[1]"));
        System.out.println(element3.getAttribute("placeholder").contains("?????????? ?? ????????????????. ????????????????,"));

        /* element3.getAttribute("placeholder").contains("?????????? ?? ????????????????. ????????????????,");*/
        Assert.assertTrue(element3.getAttribute("placeholder").contains("?????????? ?? ????????????????. ????????????????,"));

    }

    @Test
    public void first5() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        long beforeSize = getFolderSize();
        driver.get("https://the-internet.herokuapp.com/download");
        Random random = new Random();
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='example']//a"));
        list.get(random.nextInt(list.size())).click();

        long afterSize = getFolderSize();
        Assert.assertTrue(beforeSize == afterSize);
    }

    private long getFolderSize() {
        String folderPath = "C:\\Users\\st.ITSTEP";
        File file = new File(folderPath);
        long length = 0;
        for (int i = 0; i < file.list().length; i++) {
            File tmp = new File(folderPath + "\\" + file.list()[i]);
            length += tmp.length();
            System.out.println(file.list()[i] + "------------" + tmp.length());
        }
        return length;
    }


}



