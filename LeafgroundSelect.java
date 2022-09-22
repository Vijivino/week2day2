package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundSelect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//Browser setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/select.xhtml");
		driver.manage().window().maximize();
    //Select dropdown with select tag UItool
		Select sel=new Select(driver.findElement(By.xpath("//select[@class='ui-selectonemenu']")));
		sel.selectByVisibleText("Selenium");
	//select dropdown without select tag country
		driver.findElement(By.xpath("//label[@id='j_idt87:country_label']")).click();
        driver.findElement(By.xpath("//li[text()='Germany']")).click();
        Thread.sleep(3000);
    //select with above related select values city
        driver.findElement(By.xpath("//label[@id='j_idt87:city_label']")).click();
        driver.findElement(By.xpath("//li[text()='Frankfurt']")).click();
    //select with button click course 
        driver.findElement(By.xpath("//button[@class='ui-autocomplete-dropdown ui-button ui-widget ui-state-default ui-corner-right ui-button-icon-only']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[contains(text(),'Selenium')]")).click();
	//select with click language and count
	    driver.findElement(By.xpath("//label[contains(text(),'Language')]")).click();
	    driver.findElement(By.xpath("//li[text()='English']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[contains(text(),'Values')]")).click();
	    driver.findElement(By.xpath("//li[text()='Three']")).click();
	    Thread.sleep(2000);
	    driver.close();
	    
	}

}
