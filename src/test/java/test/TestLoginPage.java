package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import webpages.Login;

public class TestLoginPage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
//		WebDriverWait wait = new WebDriverWait(driver, 40);

		Login loginPage = new Login(driver);
		loginPage.openLoginPage().login("test27011993@gmail.com", "test!2345");

		driver.navigate().to("https://demo.smartosc.com/");

//		// Add product "Push It Messenger Bag" to cart
//		Actions hoverPro1 = new Actions(driver);
//		hoverPro1
//				.moveToElement(driver.findElement(By.xpath(
//						"//span[@class='product-image-container']//descendant::img[@alt='Push It Messenger Bag']")))
//				.click(driver.findElement(By.xpath("//form[@data-product-sku='24-WB04']//descendant::span"))).perform();

		viewCart(driver);
		openCheckoutPage(driver);

	}

	public static void viewCart(ChromeDriver dr1) {
		// Add product "Push It Messenger Bag" to cart
		Actions hoverPro1 = new Actions(dr1);
		hoverPro1
				.moveToElement(dr1.findElement(By.xpath(
						"//span[@class='product-image-container']//descendant::img[@alt='Push It Messenger Bag']")))
				.click(dr1.findElement(By.xpath("//form[@data-product-sku='24-WB04']//descendant::span"))).perform();
		

		Actions viewCart = new Actions(dr1);
		viewCart.click(dr1.findElement(By.xpath("//a[@class='action showcart']"))).perform();

	}

	public static void openCheckoutPage(ChromeDriver dr) {
		new WebDriverWait(dr, 20).until(ExpectedConditions.elementToBeClickable(By.id("top-cart-btn-checkout"))).click();
	}

}
