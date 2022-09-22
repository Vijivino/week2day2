package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundCheckbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//set browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        options.addArguments("disable-notifications");
//basic checkbox click
        driver.findElement(By.xpath("//span[text()='Basic']")).click();
//notification
        driver.findElement(By.xpath("//span[text()='Ajax']")).click();
//language    
        driver.findElement(By.xpath("//label[text()='Others']")).click();
        Thread.sleep(2000);
//tristate checkbox 
        //driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-c ui-icon ui-icon-check']"));
        driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[5]")).click();
//toggle switch  
        driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
//check for disabled with is selected    
       if( driver.findElement(By.xpath("//span[text()='Disabled']")).isSelected())
       {
    	   System.out.println("It is enabled");
       }
       else
       {
    	   System.out.println("It is disabled");
       }
//multiple select from dropdown   
       driver.findElement(By.xpath("//ul[@class='ui-selectcheckboxmenu-multiple-container ui-widget ui-inputfield ui-state-default ui-corner-all']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[6]")).click();
       driver.findElement(By.xpath("(//label[text()='Paris'])[2]")).click();
       driver.findElement(By.xpath("(//label[text()='Istanbul'])[2]")).click();
       driver.close();
	}

}
