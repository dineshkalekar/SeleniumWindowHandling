package WindowHanadl;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getURLText {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize(); // Maximuz the Screen

		driver.get("http://omayo.blogspot.com/");
		
		String URltext =driver.getCurrentUrl(); 
//		System.out.println(URltext);
		
//		WebElement e1=driver.findElement(By.id("selenium143"));
//		e1.click();
//		
		String nxtURL=driver.getCurrentUrl();
		
	//	System.out.println("WebURL of Current Page  ="+nxtURL);  // our webDriver still on Current Page
		
		
		String Id=driver.getWindowHandle();
	//	System.out.println("Parent ID ="+Id);
		
		
	    driver.findElement(By.xpath("//a[@id='selenium143']")).click();
	    
	    Set<String> set=driver.getWindowHandles(); 
	    
	    Iterator<String>itr=set.iterator(); 
	    while(itr.hasNext()) {
	    	String ChildID=itr.next(); // retrive Text
	    	System.out.println("It Give New Tab ChildID ="+ChildID);
	    	if(URltext.equals(ChildID)) {             // ! Not EqualsTo 
	    		String getText=driver.getTitle();
	    		System.out.println("Recieved new tab Text="+getText);
	    		
	    		String NewURl=driver.getCurrentUrl();
	    		System.out.println("New Tab URL = "+NewURl);
	    	}else
	    		System.out.println("Test case Pass");
	    	
	    	
	    }
	    
	   
	    
	    
	    
	    
		
		
		
		
		


	}

}
