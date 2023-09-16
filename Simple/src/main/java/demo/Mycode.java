package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Mycode {
@Parameters({"userName","password","first_name","last_name","address","cc_num"})
@Test
private void test1(String s1,String s2,String s3,String s4,String s5,String s6) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://adactinhotelapp.com/index.php");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys(s1);
	driver.findElement(By.id("password")).sendKeys(s2);
	driver.findElement(By.id("login")).click();
	Thread.sleep(2000);
	WebElement locat = driver.findElement(By.id("location"));
	Select s = new Select(locat);
	s.selectByIndex(1);
	WebElement htl = driver.findElement(By.id("hotels"));
	Select h = new Select(htl);
	h.selectByIndex(1);
	WebElement room = driver.findElement(By.id("room_type"));
	Select r = new Select(room);
	r.selectByIndex(3);
	driver.findElement(By.id("Submit")).click();
	driver.findElement(By.id("radiobutton_0")).click();
	driver.findElement(By.id("continue")).click();
	driver.findElement(By.id("first_name")).sendKeys(s3);
	driver.findElement(By.id("last_name")).sendKeys(s4);
	driver.findElement(By.id("address")).sendKeys(s5);
	driver.findElement(By.id("cc_num")).sendKeys(s6);
	WebElement cd = driver.findElement(By.id("cc_type"));
	Select c = new Select(cd);
	c.selectByIndex(1);
	WebElement month = driver.findElement(By.id("cc_exp_month"));
	Select m = new Select(month);
	m.selectByIndex(10);
	WebElement yr = driver.findElement(By.id("cc_exp_year"));
	Select y = new Select(yr);
	y.selectByIndex(18);
	driver.findElement(By.id("cc_cvv")).sendKeys("445");
	driver.findElement(By.id("book_now")).click();
	Thread.sleep(6000);
	JavascriptExecutor js =(JavascriptExecutor)driver;
	WebElement t = driver.findElement(By.xpath("//input[@id='order_no']"));
	js.executeScript("arguments[0].scrollIntoView", t);
	Object obj= js.executeScript("return arguments[0].getAttribute('value')",t);
	System.out.println(obj);
	driver.quit();
}
}
