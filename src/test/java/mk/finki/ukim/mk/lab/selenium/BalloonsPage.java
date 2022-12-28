package mk.finki.ukim.mk.lab.selenium;

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
@Getter
public class BalloonsPage extends AbstractPage{
    public BalloonsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "balloon")
    private List<WebElement> balloons;


    @FindBy(className = "delete_balloon")
    private List<WebElement> deleteButtons;


    @FindBy(className = "edit_balloon")
    private List<WebElement> editButtons;

    @FindBy(className = "submit")
    private List<WebElement> submitButton;


    public static BalloonsPage to(WebDriver driver) {
        get(driver, "/balloons");
        return PageFactory.initElements(driver, BalloonsPage.class);
    }

    public void assertElemts(int balloonsNumber, int deleteButtons, int editButtons, int submitButton) {
        Assert.assertEquals("rows do not match", balloonsNumber, this.getBalloons().size());
        Assert.assertEquals("delete do not match", deleteButtons, this.getDeleteButtons().size());
        Assert.assertEquals("edit do not match", editButtons, this.getEditButtons().size());
        Assert.assertEquals("submit is visible", submitButton, this.getSubmitButton().size());
    }
}
