package pageObject;

import org.openqa.selenium.By;
import pageObject.PageObject;
import pageObject.RegisterPageFormObject;

import java.util.concurrent.TimeUnit;

public class RegisterPageObject extends PageObject {

    private static final String URL_SIGN_IN = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public RegisterPageObject() {
        super(null);
        this.browser.navigate().to(URL_SIGN_IN);
    }

    public RegisterPageFormObject insertEmail(String address) {
        this.browser.findElement(By.id("email_create")).sendKeys(address);
        this.browser.findElement(By.id("SubmitCreate")).click();
        this.browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return loadRegisterPageForm();
    }

    public RegisterPageFormObject loadRegisterPageForm() {
        return new RegisterPageFormObject(browser);
    }

    public boolean isRegisterPage() {
        return browser.getCurrentUrl().equals(URL_SIGN_IN);
    }
}
