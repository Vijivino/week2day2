package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundInput {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//Browser setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/input.xhtml");
		driver.manage().window().maximize();
	//Enter text
		driver.findElement(By.id("j_idt88:name")).sendKeys("Vijayalaxmi");
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("India");
	//Check if box is disabled or not
		if (driver.findElement(By.id("j_idt88:j_idt93")).isEnabled())
		{
		System.out.println("the box is enabled");
		}
		else
		{
			System.out.println("the box is disabled");
		}
	//clear the text
		WebElement web = driver.findElement(By.id("j_idt88:j_idt95"));
		String text = web.getAttribute("value");
		//System.out.println(text);
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		Thread.sleep(2000);
	//Retrieve the text
		driver.findElement(By.id("j_idt88:j_idt97")).clear();
		driver.findElement(By.id("j_idt88:j_idt97")).sendKeys(text);	
		Thread.sleep(2000);
	//enter text
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']")).sendKeys("vijayalaxmivonothkumar19@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='j_idt88:j_idt101']")).sendKeys("I am learning automation");
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("selenium");
		driver.findElement(By.xpath("//button[@class='ql-bold']")).click();
	//error msg is diplayed or not
		//driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);
		if(driver.findElement(By.xpath("//span[@class='ui-message-error-detail']")).isDisplayed())
		{
			System.out.println("the error msg is displayed");
		}
		else
		{
			System.out.println("no error msg");
		}
	//label position is changed	
		Point location = driver.findElement(By.xpath("//label[@id='j_idt106:j_idt113']")).getLocation();
		//System.out.println(location);
		driver.findElement(By.xpath("//input[@id='j_idt106:float-input']")).click();
		Point location2 = driver.findElement(By.xpath("//label[@id='j_idt106:j_idt113']")).getLocation();
		//System.out.println(location2);
		if (location == location2)
		{
			System.out.println("label position is not changed");
		}
		else
		{
			System.out.println("label position is changed");
		}
	//dropdown with enter text
		driver.findElement(By.xpath("//input[@id='j_idt106:auto-complete_input']")).sendKeys("Viji");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@class='ui-autocomplete-item ui-autocomplete-list-item ui-corner-all'])[3]")).click();	
	//choose date
		driver.findElement(By.id("j_idt106:j_idt116_input")).sendKeys("03/19/1994");
	//enter input and spin to check it is responding
		driver.findElement(By.id("j_idt106:j_idt118_input")).sendKeys("100");
		driver.findElement(By.xpath("//a[@class='ui-spinner-button ui-spinner-up ui-corner-tr ui-button ui-widget ui-state-default ui-button-text-only']")).click();
	//to check it is increased by clicking up arrow
		WebElement element = driver.findElement(By.id("j_idt106:j_idt118_input"));
		String val = element.getAttribute("aria-valuenow");
		System.out.println(val);
		if(val.contains("101")) {
			System.out.println("the spin is worked");
		}
		else {
			System.out.println("spin is not worked");
		}
	//check slider moves
		Point location3 = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']")).getLocation();
		driver.findElement(By.id("j_idt106:slider")).sendKeys("50");
		Point location4 = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']")).getLocation();
		//String slide = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']")).getAttribute("style");
		//System.out.println(slide);
		//if (slide.contains("50")) {
		if(location3!=location4) {
			System.out.println("the slider is moved" );
		}
	//click and confirm keyboard
		driver.findElement(By.id("j_idt106:j_idt122")).click();
		if(driver.findElement(By.xpath("//div[@class='ui-widget ui-widget-content ui-corner-all ui-shadow keypad-popup ui-input-overlay']")).isDisplayed())
		{
			System.out.println("The keyboard is displayed");
		}else {
			System.out.println("No keyboard");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Close']")).click();
	//custom toolbox
		driver.findElement(By.xpath("(//button[@class='ql-bold'])[2]")).click();
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::span[@class='ql-picker-label']")).click();
		driver.findElement(By.xpath("(//span[@data-value='monospace'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")).sendKeys("hello");
		
		driver.close();		
		
		
	
	}
}
