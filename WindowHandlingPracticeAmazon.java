package WindowHanadl;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandlingPracticeAmazon {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();

		driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_custrec_signin%26adgrpid%3D58355126069%26hvpone%3D%26hvptwo%3D%26hvadid%3D610644601173%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D2513950833228139003%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9301538%26hvtargid%3Dkwd-10573980%26hydadcr%3D14453_2316415&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//a[@class='a-link-normal'])[6]")).click();

		String parentID = driver.getWindowHandle();

		System.out.println("Parent ID is ......" + parentID);

		Set<String> set = driver.getWindowHandles();

		Iterator<String> itr = set.iterator();

		while (itr.hasNext()) {
			String childID = itr.next();
			System.out.println("Child ID is ......" + childID);

			if (!parentID.equals(childID)) {
				driver.switchTo().window(childID);
				String newTabURl = driver.getCurrentUrl();
				System.out.println("New Tab URL....is...." + newTabURl);

				// driver.findElement(By.linkText("Hello. What can we help you
				// with?")).getText();
			}

		}
		driver.switchTo().window(parentID);
		String url = driver.getTitle();
		System.out.println(url);

	}

}
