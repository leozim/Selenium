package register;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import pageObject.RegisterPageObject;
import valueObjects.Form;

public class RegisterTest {

    @Test
    public void shouldGoToRegisterPageByInsertingAValidEmailAddress() {
        var registerPage = new RegisterPageObject();
        String address = "rock1@hotmail.com";

        registerPage.insertEmail(address);

        Assert.assertFalse(registerPage.isRegisterPage());

        registerPage.close();
    }

    @Test
    public void shouldRegisterAnUserWithValidData() {
        var registerPage = new RegisterPageObject();
        String address = "rock12@hotmail.com" + RandomStringUtils.random(2, true, true);

        var registerPageForm =  registerPage.insertEmail(address);
        registerPageForm.submitForm(Form.build(address));

        Assert.assertTrue(registerPageForm.isAccountPage());

        registerPage.close();
    }

}
