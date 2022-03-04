package test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Amazonsearch {
public static WebDriver driver;
public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("iphone12");
		WebElement searchbtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbtn.click();
		List<WebElement> text = new ArrayList<>(driver.findElements(By.xpath("//span[@class ='a-size-medium a-color-base a-text-normal']")));
		List<WebElement> price = new ArrayList<>(driver.findElements(By.xpath("//span[@class ='a-price-whole']")));
		HashMap<String,String> values= new HashMap<String,String>();
		System.out.println(text.size());
		for (int i=0;i<=price.size()-1;i++) {
			if (text.get(i).getText().contains("Apple iPhone 12")) {
			
			values.put(text.get(i).getText(), price.get(i).getText());
		}
		}
		for(Map.Entry<String, String> entry1 :values.entrySet()) {
		System.out.println(entry1.getKey() + "        "+entry1.getValue());
		} 
		
		driver.close();
}
}
