package pages.samplepagetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MassageSent {
    WebDriver driver;
    public MassageSent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//blockquote[@class='contact-form-submission']")
    WebElement savedTextForm;
    @FindBy(xpath = "//blockquote//p[1]")
    WebElement savedTextName;
    @FindBy(xpath = "//blockquote//p[2]")
    WebElement savedTextEmail;
    @FindBy(xpath = "//blockquote//p[3]")
    WebElement savedTextWebSite;
    @FindBy(xpath = "//blockquote//p[4]")
    WebElement savedTextExperienceInYears;
    @FindBy(xpath = "//blockquote//p[5]")
    WebElement savedTextExpertise;
    @FindBy(xpath = "//blockquote//p[6]")
    WebElement savedTextEducation;
    @FindBy(xpath = "//blockquote//p[7]")
    WebElement savedTextComment;

    @FindBy(xpath = "//blockquote//p[7]")
    WebElement savedTextWriteLogin;



    public String waitText(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElement(savedTextForm, "Name: "));
        return null;
    }


    public String getTextForm(){
        return savedTextForm.getText();
    }
    public String getTextFormName(){
        return savedTextName.getText();
    }
    public String getTextFormEmail(){
        return savedTextEmail.getText();
    }
    public String getTextFormWebsite(){
        return savedTextWebSite.getText();
    }
    public String getTextFormExperienceInYears(){
        return savedTextExperienceInYears.getText();
    }
    public String getTextFormExpertise(){
        return savedTextExpertise.getText();
    }public String getTextFormEducation(){
        return savedTextEducation.getText();
    }
    public String getTextFormComment(){
        return savedTextComment.getText();
    }


}
