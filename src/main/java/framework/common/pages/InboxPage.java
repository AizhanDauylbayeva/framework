package framework.common.pages;

import framework.core.util.MyLogger;
import framework.core.util.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class InboxPage extends BasePage {

    @FindBy(xpath = "//*[@id='PH_user-email']")
    private WebElement userEmailIdentificator;

    @FindBy(xpath = "//*[@id='b-toolbar__left']//span")
    private WebElement createNewMailButton;

    @FindBy(xpath = "//span[@class='js-text-inner pm-toolbar__button__text__inner' and contains(string(), 'Облако')]")
    private WebElement cloudButton;

    public void openWriteNewMail() {
        createNewMailButton.click();
    }

    public String getUserName() {
        Waiting.waitForElementVisibleEnabled(userEmailIdentificator);
        return userEmailIdentificator.getText();
    }

    public CloudPage openCloudPage() {
        MyLogger.LOGGER.info("Clicking cloud button");
        cloudButton.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        MyLogger.LOGGER.info("Switching to the new tab");
        driver.switchTo().window(tabs.get(1));
        return new CloudPage();
    }
}
