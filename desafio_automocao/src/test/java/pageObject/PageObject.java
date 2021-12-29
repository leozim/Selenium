package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Usuario\\IdeaProjects\\desafio_automocao\\src\\drivers\\msedgedriver.exe");
        this.browser = browser != null ? browser : new EdgeDriver();
    }

    public void close() {
        this.browser.quit();
    }
}
