package StepDeffination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageObject.Addcustomer;
import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef 

{
	public WebDriver driver;

	public LoginPage l;

	public Addcustomer ad;

	@Given("user Launch Chrome Browser")
	public void user_launch_chrome_browser()
	{
		    ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(options);

			l = new LoginPage(driver);
			ad = new Addcustomer(driver);
		}
	

	@When("User opens url {string}")
	public void user_opens_url(String url) throws InterruptedException
	{

			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(3000);
		}
	

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String mail, String pwd) 
	{
		l.enterEmail(mail);
		l.enterPassword(pwd);

	}

	@When("Click on Login")
	public void click_on_login()
	{
		l.clickOnLoginButton();
	
	}
	@Then("Page Title should be {string}")
	public void page_title_should_be(String exptitle) 
	{

		String actualtitle = driver.getTitle();

		if (actualtitle.equals(exptitle)) {

			System.out.println("True");
		} else {
			System.out.println("False");

		}
	}

	@When("User click on customer Menu")
	public void user_click_on_customer_menu()
	{
		ad.ClickCutomerMenu();
	
	}

	@When("click on customer Menu item")
	public void click_on_customer_menu_item() 
	{
		ad.ClickCustomerMenuItem();

	}

	@When("click on Add new button")
	public void click_on_add_new_button()
	{
		ad.Addnew();
	
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() 
	{
		String actualurl = driver.getCurrentUrl();

		String expecturl = "https://admin-demo.nopcommerce.com/Admin/Customer/Create";

		if (actualurl.equals(expecturl)) {
			System.out.println("Correct page");
		} else {
			System.out.println("Incorrect");
		}

	}

	@When("user enter customer page")
	public void user_enter_customer_page()
	{
		ad.setEmail("meenu123@mail.com");

		ad.setPassword("1234");

		ad.setFirstname("meenu");

		ad.setLname("sharma");

		ad.setDob("20/10/1985");

		ad.setGender("female");
	
	}

	@When("click on save button")
	public void click_on_save_button()
	{
	 ad.clickonsave();
	}
	
	@When("User click on the log out link")
	public void user_click_on_the_log_out_link() 
	{
		l.clickOnLogOutButton();
	}

	@When("close browser")
	public void close_browser() 
	{
		driver.close();
	  
	}

}
