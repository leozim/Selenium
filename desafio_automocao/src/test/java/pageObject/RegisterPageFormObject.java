package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageObject.PageObject;
import pageObject.BuyPageObject;
import valueObjects.Form;

import java.util.concurrent.TimeUnit;

public class RegisterPageFormObject extends PageObject {

    private static final String DEFAULT_URL = "http://automationpractice.com/index.php";
    private static final String REGISTER_PAGE_FORM_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
    public static final String MY_ACCOUNT_URL = "http://automationpractice.com/index.php?controller=my-account";

    public RegisterPageFormObject(WebDriver browser) {
        super(browser);
        this.browser.navigate().to(REGISTER_PAGE_FORM_URL);
    }

    public BuyPageObject submitForm(Form form) {

        this.browser.findElement(By.id("id_gender1")).click();
        this.browser.findElement(By.id("customer_firstname")).sendKeys(form.getFirstName());
        this.browser.findElement(By.id("customer_lastname")).sendKeys(form.getLastName());
        this.browser.findElement(By.id("passwd")).sendKeys(form.getPassword());

        selectBirthDay();

        this.browser.findElement(By.id("address1")).sendKeys(form.getPublicPlace());
        this.browser.findElement(By.id("city")).sendKeys(form.getCity());

        selectState();

        this.browser.findElement(By.id("postcode")).sendKeys(form.getZipCode());

        selectCountry();

        this.browser.findElement(By.id("phone_mobile")).sendKeys(form.getCellPhone());
        this.browser.findElement(By.id("submitAccount")).click();
        this.browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return new BuyPageObject(this.browser);
    }

    public void selectBirthDay() {
        new Select(this.browser.findElement(By.id("days"))).selectByIndex(1);
        new Select(this.browser.findElement(By.id("months"))).selectByIndex(1);
        new Select(this.browser.findElement(By.id("years"))).selectByIndex(1);
    }

    public void selectState() {
        new Select(this.browser.findElement(By.id("id_state"))).selectByIndex(1);
    }

    public void selectCountry() {
        new Select(this.browser.findElement(By.id("id_country"))).selectByIndex(1);
    }

    public boolean isAccountPage() {
        return this.browser.getCurrentUrl().equals(DEFAULT_URL);
    }

}
