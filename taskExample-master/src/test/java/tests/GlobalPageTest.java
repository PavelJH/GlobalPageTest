package tests;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.samplepagetest.MassageSent;
import pages.samplepagetest.SamplePage;

public class GlobalPageTest extends TestBase{
    Faker faker = new Faker();
    SamplePage samplePage;
    MassageSent massageSent;
    String firstName = faker.name().firstName();
    String emailName = faker.internet().emailAddress();
    String webSite = "https://skilldesk.starta.university/members/login";

    Lorem comment = faker.lorem();

    @Test
    public void fillingInformationAllDateFilled(){
        samplePage = new SamplePage(driver);
        samplePage.fillDataGlobalSQA(firstName,emailName,webSite);
        samplePage.selectValue("1-3");
        samplePage.choiceValueDataExpertise();
        samplePage.choiceValueDataEducation();
        samplePage.commentaryField(String.valueOf(comment));
        samplePage.clickAlertBoxButton();
        Assert.assertTrue(samplePage.getTextAlert().contains("Do you really fill rest of the form?"));
        samplePage.acceptAlert();
        Assert.assertTrue(samplePage.getTextAlert().contains("Good Luck. Go for it"));
        samplePage.acceptAlert();

        massageSent = new MassageSent(driver);
        massageSent.waitText();
        Assert.assertTrue(massageSent.getTextFormName().contains("Name: " + firstName));
        Assert.assertTrue(massageSent.getTextFormEmail().contains("Email: " + emailName));
        Assert.assertTrue(massageSent.getTextFormWebsite().contains("Website: " + webSite));
        Assert.assertTrue(massageSent.getTextFormExperienceInYears().contains("Experience (In Years): " + "1-3"));
        Assert.assertTrue(massageSent.getTextFormExpertise().contains("Expertise :: " + "Automation Testing"));
        Assert.assertTrue(massageSent.getTextFormEducation().contains("Education: " + "Other"));
        Assert.assertTrue(massageSent.getTextFormComment().contains("Comment: " + comment));
    }
    @Test
    public void fillingInformationWithoutNameFill(){
        samplePage = new SamplePage(driver);

        samplePage.fillDataGlobalSQAWithoutName(emailName,webSite);
        samplePage.selectValue("1-3");
        samplePage.choiceValueDataExpertise();
        samplePage.choiceValueDataEducation();
        samplePage.commentaryField(String.valueOf(comment));
        samplePage.clickAlertBoxButton();
        Assert.assertTrue(samplePage.getTextAlert().contains("Do you really fill rest of the form?"));
        samplePage.acceptAlert();
        Assert.assertTrue(samplePage.getTextAlert().contains("Good Luck. Go for it"));
        samplePage.acceptAlert();
        Assert.assertTrue(samplePage.samplePageTest());

    }
}
