package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.PageObject;

import java.util.concurrent.TimeUnit;

public class BuyPageObject extends PageObject {

    private static final String DEFAULT_URL = "http://automationpractice.com/index.php";
    private static final String PRODUCT_URL = "http://automationpractice.com/index.php?controller=order&ipa=1";
    private static final String CHECKOUT_URL = "http://automationpractice.com/index.php?controller=order&step=1";
    private static final String CHECKOUT_SHIPPING_URL = "http://automationpractice.com/index.php?controller=order";
    private static final String CHECKOUT_PAYMENT_URL = "http://automationpractice.com/index.php" +
            "?fc=module&module=bankwire&controller=payment";

    private static final String PAYMENT_URL = "http://automationpractice.com/index.php" +
            "?controller=order-confirmation&id_cart=4138973&id_module=" +
            "3&id_order=392913&key=70187f358e168e32afdcd3a581b69224";


    public BuyPageObject(WebDriver browser) {
        super(browser);
        this.browser.navigate().to(DEFAULT_URL);
    }

    public void selectClothe() {
        this.browser.findElement(By.cssSelector(".button.ajax_add_to_cart_button")).click();
        this.browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void clickCheckoutButton() {
        this.browser.findElement(By.cssSelector(".button.button-medium")).click();
        this.browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void confirmSummary() {
        this.browser.findElement(By.className("standard-checkout")).click();
        this.browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void confirmAddress() {
        this.browser.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        this.browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void acceptShippingTerms() {
        this.browser.findElement(By.id("cgv")).click();
    }

    public void confirmShipping() {
        acceptShippingTerms();
        this.browser.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
        this.browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void confirmPayment() {
        this.browser.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
        this.browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public boolean isPaymentConfirmed() {
        return this.browser.getCurrentUrl().equals(DEFAULT_URL);
    }
}
