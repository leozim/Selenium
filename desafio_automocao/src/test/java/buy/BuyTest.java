package buy;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import pageObject.RegisterPageObject;
import valueObjects.Form;

public class BuyTest {

    @Test
    public void shouldBuySomethingAfterSignUp() {
        var registerPage = new RegisterPageObject();
        String address = "rock12@hotmail.com" + RandomStringUtils.random(2, true, true);

        var registerPageForm =  registerPage.insertEmail(address);
        var form = Form.build(address);

        var buyPageObject  = registerPageForm
                .submitForm(form);

        buyPageObject.selectClothe();
        buyPageObject.clickCheckoutButton();
        buyPageObject.confirmSummary();
        buyPageObject.confirmAddress();
        buyPageObject.confirmShipping();
        buyPageObject.confirmPayment();

        Assert.assertTrue(buyPageObject.isPaymentConfirmed());

        buyPageObject.close();
    }

}
