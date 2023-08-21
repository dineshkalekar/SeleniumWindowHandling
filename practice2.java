package WindowHanadl;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class practice2 {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize(); // Maximuz the Screen

		driver.get("https://demoqa.com/browser-windows");
		
		driver.findElement(By.xpath("//button[@id='tabButton']")).click();
		
		Set<String>s1=driver.getWindowHandles();
		
		Iterator<String> it=s1.iterator();
		
		while(it.hasNext()) {
			String child=it.next();
			if(!s1.equals(child)) {
				driver.switchTo().window(child);
				String title=driver.getTitle();
				System.out.println(title);
				String URl=driver.getCurrentUrl();
				System.out.println("parent ="+URl);
				
				driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]"));
				String text1=driver.getTitle();
				System.out.println("Child="+text1);
			}	
		}
	}

}
