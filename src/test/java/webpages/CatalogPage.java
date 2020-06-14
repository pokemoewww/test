package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {
	
	WebDriver driver;
	
	public void addToCart(WebDriver dr) {
		// Add product "Push It Messenger Bag" to cart
				Actions hoverPro1 = new Actions(dr);
				hoverPro1.moveToElement(dr.findElement(By.xpath("//span[@class='product-image-container']//descendant::img[@alt='Push It Messenger Bag']")))
				.click(dr.findElement(By.xpath("//form[@data-product-sku='24-WB04']//descendant::span")))
				.perform();
	}
	
	public void clickBtnCheckout(WebDriver dr) {
		Actions viewCart = new Actions(dr);
		viewCart.click(dr.findElement(By.xpath("//a[@class='action showcart']"))).perform();
		
		Actions proceed = new Actions(dr);
		proceed.click(dr.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"))).perform();
	}
	

}
