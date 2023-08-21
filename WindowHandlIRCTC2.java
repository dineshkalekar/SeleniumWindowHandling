package WindowHanadl;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WindowHandlIRCTC2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().window().maximize();

		WebElement e1 = driver.findElement(By.xpath("//span[@class='allcircle circletwo']"));

		e1.click();

		String prtID = driver.getWindowHandle();
		System.out.println("prtID==...." + prtID);

		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();

		while (itr.hasNext()) {
			String child = itr.next();
			if (!prtID.equals(child)) {

				driver.switchTo().window(child);
				String urlchild = driver.getCurrentUrl();
				System.out.println(urlchild);

				break;
			}
		}
		driver.switchTo().window(prtID);
		String s1 = driver.getCurrentUrl();
		System.out.println(s1);

		WebElement e2 = driver.findElement(By.xpath("//span[@class='allcircle circlefive']"));

		e2.click();
		
		while(itr.hasNext()) {
			String child1=itr.next();
			if(! prtID.equals(child1)) {
				driver.switchTo().window(child1);
				String child1ID=driver.getWindowHandle();
				System.out.println("Child 1 ID..."+child1ID);
				
			}
			
		}
	
	}

}
