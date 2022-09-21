package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	

	// Download and set the path 	
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://en-gb.facebook.com/");
	//Maximise the window and Add implicit wait
		 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//enter text fields    
	     driver.findElement(By.xpath("//div[@class='_6ltg']/a")).click();
         driver.findElement(By.name("firstname")).sendKeys("Viji");
         driver.findElement(By.name("lastname")).sendKeys("Vinoth");
         driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("7418243994");
         driver.findElement(By.name("reg_passwd__")).sendKeys("1234");
    //Handle all the three drop downs
         Select sel=new Select(driver.findElement(By.name("birthday_day")));
         sel.selectByVisibleText("19");
         Select sel2=new Select(driver.findElement(By.xpath("//select[@id='month']")));
         sel2.selectByValue("3");
         Select sel3=new Select (driver.findElement(By.name("birthday_year")));
         sel3.selectByVisibleText("1994");
    //Select the radio button "Female"     
         //driver.findElement(By.linkText("Female")).click();
         driver.findElement(By.xpath("//label[text()='Female']")).click();
         
	}

}
