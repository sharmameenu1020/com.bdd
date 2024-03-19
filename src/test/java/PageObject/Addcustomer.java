package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Addcustomer {

	public WebDriver ldriver;

	public Addcustomer(WebDriver driver) {

		ldriver = driver;

		PageFactory.initElements(ldriver, this);

	}

	By lnkCutomersmenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");

	By lnkCutomers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

	By btnAddnew = By.xpath("//a[normalize-space()='Add new']");

	By txtEmail = By.name("Email");

	By txtpassword = By.name("Password");

	By txtfirstname = By.name("FirstName");

	By txtlastname = By.name("LastName");

	By txtradio = By.name("Gender");

	By rdMalegender = By.xpath("//*[@id=\"Gender_Male\"]");

	By rdFemalegender = By.xpath("//*[@id=\"Gender_Male\"]");

	By txtdob = By.name("DateOfBirth");

	By drpmgrvndr = By.id("VendorId");

	By txtsave = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");

	public void ClickCutomerMenu() {
		ldriver.findElement(lnkCutomersmenu).click();

	}

	public void ClickCustomerMenuItem() {
		ldriver.findElement(lnkCutomers_menuitem).click();
	}

	public void Addnew() {
		ldriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		ldriver.findElement(txtpassword).sendKeys(password);
	}

	public void setFirstname(String fname) {
		ldriver.findElement(txtfirstname).sendKeys(fname);
	}

	public void setLname(String lname) {
		ldriver.findElement(txtlastname).sendKeys(lname);
	}

	public void setManagerofVendor(String value) {
		Select drp = new Select(ldriver.findElement(drpmgrvndr));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(rdMalegender).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(rdFemalegender).click();
		}

		else {
			ldriver.findElement(rdMalegender).click();
		}
	}

	public void setDob(String dob) {
		ldriver.findElement(txtdob).sendKeys(dob);
	}

	public void clickonsave() {

		ldriver.findElement(txtsave).click();
	}

}
