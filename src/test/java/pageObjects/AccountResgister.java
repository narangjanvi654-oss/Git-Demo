
	package pageObjects;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	public class AccountResgister extends BasePage {

		public AccountResgister(WebDriver driver) {
			super(driver);
		}

		// Locators
		@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
		@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
		@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
		@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
		@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
		@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
		@FindBy(xpath="//input[@name='agree']") WebElement chkdPolicy;
		@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
		
		// Confirmation Message Locator (Pavan ke lecture ke hisaab se missing tha)
		@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") 
		WebElement msgConfirmation;

		// Action methods
		public void setFirstname(String fname) {
			txtFirstname.sendKeys(fname); // Quotes hata diye, ab variable use hoga
		}

		public void setLastname(String lname) {
			txtLastname.sendKeys(lname);
		}

		public void setEmail(String mail) {
			txtEmail.sendKeys(mail);
		}

		public void setTelephone(String phone) {
			txtTelephone.sendKeys(phone);
		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
		}

		public void setConfirmPassword(String pwd) {
			txtConfirmPassword.sendKeys(pwd);
		}

		public void setPrivacyPolicy() {
			chkdPolicy.click();
		}

		public void clickContinue() {
			btnContinue.click();
		}

		// Proper Confirmation Message Method
		public String getConfirmationMsg() {
			try {
				return (msgConfirmation.getText());
			} catch (Exception e) {
				return (e.getMessage());
			}
		}
	}

