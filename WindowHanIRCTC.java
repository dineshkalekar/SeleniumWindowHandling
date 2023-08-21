package WindowHanadl;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHanIRCTC {

	public static void main(String[] args) {
WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().window().maximize();
		
		WebElement e1=driver.findElement(By.xpath("//span[@class='railDrishti fa fa-bus']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", e1);
		
		
		
		String ParentID=driver.getWindowHandle();
		System.out.println("Parent ID..="+ParentID);  // action & Print Done
		 
		Set<String> set=driver.getWindowHandles();
		Iterator<String>itr=set.iterator();
		
		while(itr.hasNext()) {
			String Child=itr.next();
			if(!ParentID.equals(Child)) {
				driver.switchTo().window(Child);
				String ChildID=driver.getTitle();
				System.out.println("Child TITLE..."+ChildID);  // action & Print Done
				
			break;	
			}
			
		}
		driver.switchTo().window(ParentID);
		String ParTITL=driver.getTitle();
		System.out.println(ParTITL);   // action & Print Done
	
		// new Web tab Open (third tab)
		WebElement e2=driver.findElement(By.xpath("//span[@class='allcircle circleone']"));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", e2);
		
		while(itr.hasNext()) {
			String child2=itr.next();
			if(!ParentID.equals(child2)) {
				driver.switchTo().window(child2);
				
//				String TitleChild2=driver.getTitle();
//				System.out.println("We recieved Child2 ..Title =="+TitleChild2);
				String Child2URl=driver.getCurrentUrl();
				System.out.println(Child2URl);  // action Work but not print in consol
			break;	
			}
			
		}
		driver.switchTo().window(ParentID);
		String s1=driver.getCurrentUrl();
		System.out.println("Parent URl"+s1);// Action & print done
		
	}
	
	

}
