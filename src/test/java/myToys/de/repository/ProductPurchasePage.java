package myToys.de.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myToys.de.resource.CommonActions;

public class ProductPurchasePage extends CommonActions{
	public ProductPurchasePage() {
		PageFactory.initElements(driver, this);
	}
	@FindAll({@FindBy(partialLinkText ="//*[contains(text(),'in the cart')]"),@FindBy(partialLinkText ="//*[contains(text(),'In den Warenkorb')]")})
	private WebElement toTheCart;
	
	@FindBy(xpath ="//span[@data-wt-name='top.spielzeug']")
	private WebElement productList;
	
	@FindBy(xpath = "(//div[class='view-options view-options--top']|//div[@class='sort'])[1]")
	private WebElement scrollupproduct;
	
	@FindBy(xpath = "(//a[@class='prod-tile__link js-prodlink'])[1]")
	private WebElement selectProduct;


	public WebElement getToTheCart() {
		return toTheCart;
	}

	public WebElement getProductList() {
		return productList;
	}

	public WebElement getScrollupproduct() {
		return scrollupproduct;
	}

	public WebElement getSelectProduct() {
		return selectProduct;
	}
	
	
		
	
		
	

}
