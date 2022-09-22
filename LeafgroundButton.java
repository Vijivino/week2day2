package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundButton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
	//click and check title	
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		String title = driver.getTitle();
		System.out.println("title is verified "+title);
		driver.navigate().back();
    //disabled button 
		if(driver.findElement(By.id("j_idt88:j_idt92")).isEnabled())
		{
			System.out.println("The button is enabled");
		}
		else
		{
			System.out.println("The button is disabled");
		}
	//find position
		Point location = driver.findElement(By.xpath("//span[text()='Submit']")).getLocation();
		System.out.println("The position of submit button is "+location);
	//save button colour
		String cssValue = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']")).getCssValue("background-color");
		System.out.println("Color is " +cssValue);
	//height and width of button
		Dimension size = driver.findElement(By.xpath("(//span[text()='Submit'])[2]")).getSize();
		System.out.println("height and width are " +size );
	//mouse over color change
		String initialcolor = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']")).getCssValue("background-color");
	    System.out.println("initial color is "+initialcolor);
	    WebElement place = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']"));
	    Actions act=new Actions(driver);
	    act.moveToElement(place).perform();
		String changedcolor = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']")).getCssValue("background-color");
	    System.out.println("After mouse over changed color is " +  changedcolor);
	//click image
	    driver.findElement(By.xpath("//button[@id='j_idt88:j_idt102:imageBtn']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@id='j_idt88:j_idt102:imageBtn']")).click();
	    
	//check and count the round button
	    driver.findElement(By.xpath("//span[text()='Primary']")).click();
	    WebElement button1 = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only rounded-button mr-2 mb-2']"));
	      String b1 = button1.getAttribute("class");
	      //System.out.println(b1);
	      int count=0;
	         if(b1.contains("round")) {
	    	count++;
	       }
	    //System.out.println(count);
	    WebElement button2 = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only rounded-button ui-button-danger mr-2 mb-2']"));
		   String b2 = button2.getAttribute("class");
		   //int count=0;
		    if(b2.contains("round")) {
		    	count++;
		    }
		WebElement button3 = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only rounded-button ui-button-success mr-2 mb-2']"));
		   String b3 = button3.getAttribute("class"); 
			    if(b3.contains("round")) {
			    	count++;
			    }
		WebElement button4 = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only rounded-button ui-button-warning mr-2 mb-2']"));
		 String b4 = button4.getAttribute("class"); 	     
		      if(b4.contains("round")) {
				    	count++;
				    }
		System.out.println("The rounded button count is " +count);	
		
		driver.close();		    
	}

}
