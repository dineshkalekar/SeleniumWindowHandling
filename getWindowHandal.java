package WindowHanadl;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getWindowHandal {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize(); // Maximuz the Screen

		driver.get("http://omayo.blogspot.com/");
		
		String URL =driver.getCurrentUrl(); 
		System.out.println("CurrentPageURL="+URL);
		
		
		String ParentID=driver.getWindowHandle();
		System.out.println("Parent ID Is ="+ParentID);
		
		WebElement e1=driver.findElement(By.id("selenium143"));
		e1.click();
		
		
	//	String ID=driver.getWindowHandles();
		
		
		
		Set<String> ChildWindow=driver.getWindowHandles();
		
			
//		for (String val : ChildWindow) {       // 1st Way
//			System.out.println("Child ID ="+val);
//			
//			
//		}		
		Iterator<String> it=ChildWindow.iterator(); // 2nd way
		while(it.hasNext()) {
			String WinID=it.next();
			System.out.println("Child ID ="+WinID);
			
			if(!ParentID.equalsIgnoreCase(WinID)) {
				driver.switchTo().window(WinID);
				String text=driver.getTitle();
				System.out.println(text);
				String text1=driver.getCurrentUrl();
				System.out.println(text1);
				
			}
		}
		
		
	}

}
