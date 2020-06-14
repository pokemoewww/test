package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	WebDriver driver;
	String URL_LOGIN = "https://demo.smartosc.com/customer/account/login";
	String URL_HOMEPAGE = "https://demo.smartosc.com/";
	
	@FindBy (id="email")
	private WebElement inputEmail;
	
	@FindBy (id="pass")
	private WebElement inputPassword;
	
	@FindBy (id="send2")
	private WebElement btnLogin;
	

	public Login(ChromeDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Login openLoginPage() {
		driver.get(URL_LOGIN);	
//		driver.manage().window().maximize();
		return this;
	}
	
	public void waitFor(WebElement element, long waitingTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitingTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(WebElement element) {
		waitFor(element, 60);
		element.click();
	}
	
	public Login login(String name, String password) {
		inputEmail.sendKeys(name);
		inputPassword.sendKeys(password);
		btnLogin.click();
		
//		driver.navigate().to(URL_HOMEPAGE);
		return this;	
	}
	

	
}
