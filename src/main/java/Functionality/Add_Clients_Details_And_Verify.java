package Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Add_Clients_Details_And_Verify {

    private WebDriver driver;

    public Add_Clients_Details_And_Verify(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy (id = "MnuNewClient")
    WebElement Menu;
    @FindBy (id="ddlTitle")
    WebElement Title;
    @FindBy (id="txtSurname")
    WebElement Surname;
    @FindBy (id="TxtDOB")
    WebElement Date_Of_Birth;
    @FindBy (id = "btnSave")
    WebElement Save_Button;

    @FindBy(xpath = "//Firstname[1]")
    WebElement Added_Surname;

    public void Click_Menu()
    {
        WebDriverWait menu=new WebDriverWait(driver,20);
        menu.until(ExpectedConditions.visibilityOf(Menu));
        Menu.click();
    }
    public void Select_Title(String _title)
    {
        WebDriverWait title=new WebDriverWait(driver,20);
        title.until(ExpectedConditions.visibilityOf(Title));
        Select title_value=new Select(Title);
        title_value.selectByVisibleText(_title);
    }
    public void Enter_Surname(String _surname)
    {
        WebDriverWait surname=new WebDriverWait(driver,20);
        surname.until(ExpectedConditions.visibilityOf(Surname));
        Surname.sendKeys(_surname);
    }
    public void Enter_Date_Of_Birth(String _dob)
    {
        WebDriverWait dob=new WebDriverWait(driver,20);
        dob.until(ExpectedConditions.visibilityOf(Date_Of_Birth));
        Date_Of_Birth.sendKeys(_dob);
    }
    public void Click_Save()
    {
        WebDriverWait save=new WebDriverWait(driver,20);
        save.until(ExpectedConditions.visibilityOf(Save_Button));
        Save_Button.click();
    }
    public void Verify_That_Client_Was_Added(String _lastname)
    {
        WebDriverWait verify=new WebDriverWait(driver,20);
        verify.until(ExpectedConditions.visibilityOf(Added_Surname));

        Assert.assertEquals(Added_Surname.getText(),_lastname);
    }
}
