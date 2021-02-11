package com.sekolahqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reports extends BasePage{
    private By menuPIM = new By.ByXPath("//*[@id='menu_pim_viewPimModule']");
    private By menuReports = new By.ByXPath("//*[@id='menu_core_viewDefinedPredefinedReports']");
    private By btnAdd = new By.ByXPath("//*[@id='btnAdd']");
    private By fieldReportName = new By.ByXPath("//*[@id='report_report_name']");
    private By selectCriteria = new By.ByXPath("//*[@id='report_criteria_list']");
    private By btnAddCriteria = new By.ByXPath("//*[@id='btnAddConstraint']");
    private By selectFieldGroup = new By.ByXPath("//*[@id='report_display_groups']");
    private By btnAddFieldGroup = new By.ByXPath("//*[@id='btnAddDisplayGroup']");
    private By selectFieldList = new By.ByXPath("//*[@id='report_display_field_list']");
    private By btnAddFieldList = new By.ByXPath("//*[@id='btnAddDisplayField']");
    private By fieldEmployeeName = new By.ByXPath("//*[@id='employee_name_empName']");
    private By btnSave = new By.ByXPath("//*[@id='btnSave']");
    private By fieldSearchReportName = new By.ByXPath("//*[@id='search_search']");
    private By btnSearch = new By.ByXPath("//*[@id='searchForm']/fieldset/p/input[1]");
    private By searchResult = new By.ByXPath("//*[@id='resultTable']/tbody/tr/td[2]");

    public Reports(WebDriver driver) { super(driver); }

    public void adminGoToReportsPage () throws InterruptedException{
        clickButton(menuPIM);
        clickButton(menuReports);
    }

    public void clickButtonAdd() throws InterruptedException{
        clickButton(btnAdd);
    }

    public void inputReportName(String reportName) throws InterruptedException{
        inputText(fieldReportName,reportName);
    }

    public void addCriteria() throws InterruptedException{
        selectOption(selectCriteria, "Employee Name");
        clickButton(btnAddCriteria);
    }

    public void inputReportEmployeeName(String fullName) throws InterruptedException{
        inputText(fieldEmployeeName, fullName);
        enterInTextBox(fieldEmployeeName);
    }

    public void addAllFromFieldGroup(String fieldGroup) throws InterruptedException{
        selectOption(selectFieldGroup,fieldGroup);
        clickButton(btnAddFieldGroup);
    }

    public void addFieldList(String fieldGroup, String fieldName) throws InterruptedException{
        selectOption(selectFieldGroup,fieldGroup);
        selectOption(selectFieldList, fieldName);
        clickButton(btnAddFieldList);
    }

    public void clickSaveButton() throws InterruptedException{
        clickButton(btnSave);
    }

    public void inputSearchReport(String reportName) throws InterruptedException{
        inputText(fieldSearchReportName, reportName);
        enterInTextBox(fieldSearchReportName);
    }

    public void clickSearch() throws InterruptedException{
        clickButton(btnSearch);
    }

    public void verifySearchResult(String reportName) throws InterruptedException{
        verifyText(searchResult, reportName);
    }


}
