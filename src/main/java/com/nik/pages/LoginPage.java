package com.nik.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//By username=By.xpath("//input[@name='username']");
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	//By password=By.xpath("//input[@name='password']");
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}
	
	

}
