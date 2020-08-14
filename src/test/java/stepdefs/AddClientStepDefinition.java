package stepdefs;

import Functionality.Add_Clients_Details_And_Verify;
import Setup.Setup_Class;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class AddClientStepDefinition {
    private WebDriver driver = Setup_Class.startBrowserOfChoice("www.Clients.co.za","chrome");

    private static String dir = System.getProperty("user.dir");
    private static final String excel = dir + "/src/main/java/Test_Data/Test_Data.xlsx";
    private FileInputStream fis = new FileInputStream(excel);
    private XSSFWorkbook workbook = new XSSFWorkbook(fis);

    private XSSFSheet sheet = workbook.getSheetAt(0);
    String Title=sheet.getRow(1).getCell(0).getStringCellValue();
    String Surname=sheet.getRow(1).getCell(0).getStringCellValue();
    String DOB=sheet.getRow(1).getCell(0).getStringCellValue();

    public AddClientStepDefinition() throws IOException {
    }
    @Given("^I Have <Captured> New Clients Details$")
    public void iHaveCapturedNewClientsDetails() {
        Add_Clients_Details_And_Verify add_clients_details_and_verify= PageFactory.initElements(driver,Add_Clients_Details_And_Verify.class);
        add_clients_details_and_verify.Click_Menu();
        add_clients_details_and_verify.Select_Title(Title);
        add_clients_details_and_verify.Enter_Surname(Surname);
        add_clients_details_and_verify.Enter_Date_Of_Birth(DOB);
    }
    @When("^Click The <Save> Button$")
    public void clickTheSaveButton() {
        Add_Clients_Details_And_Verify add_clients_details_and_verify= PageFactory.initElements(driver,Add_Clients_Details_And_Verify.class);
        add_clients_details_and_verify.Click_Save();
    }
    @Then("^Clients Details Must Be <Saved> Successfully$")
    public void clientsDetailsMustBeSavedSuccessfully() {
        Add_Clients_Details_And_Verify add_clients_details_and_verify= PageFactory.initElements(driver,Add_Clients_Details_And_Verify.class);
        add_clients_details_and_verify.Verify_That_Client_Was_Added(Surname);
    }
}
