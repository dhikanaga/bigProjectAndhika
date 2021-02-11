package com.sekolahqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Leave extends BasePage{
    private By menuLeave = new By.ByXPath("//*[@id='menu_leave_viewLeaveModule']/b");
    private By menuEntitlements = new By.ByXPath("//*[@id='menu_leave_Entitlements']");
    private By addEntitlements = new By.ByXPath("//*[@id='menu_leave_addLeaveEntitlement']");
    private By employeeName = new By.ByXPath("//*[@id='entitlements_employee_empName']");
    private By leaveType = new By.ByXPath("//*[@id='entitlements_leave_type']");
    private By entitlementsBalance = new By.ByXPath("//*[@id='entitlements_entitlement']");
    private By btnSave = new By.ByXPath("//*[@id='btnSave']");
    private By applyLeave = new By.ByXPath("//*[@id='menu_leave_applyLeave']");
    private By employeeLeavetype = new By.ByXPath("//*[@id='applyleave_txtLeaveType']");
    private By employeeLeaveFrom = new By.ByXPath("//*[@id='applyleave_txtFromDate']");
    private By employeeLeaveTo = new By.ByXPath("//*[@id='applyleave_txtToDate']");
    private By employeeLeaveComment = new By.ByXPath("//*[@id='applyleave_txtComment']");
    private By btnApply = new By.ByXPath("//*[@id='applyBtn']");
    private By errorMessage = new By.ByXPath("//*[@id='frmLeaveApply']/fieldset/ol/li[4]/span");

    public Leave(WebDriver driver) { super(driver); }

    public void adminGoToEntitlements()throws InterruptedException {
        clickButton(menuLeave);
        clickButton(menuEntitlements);
        clickButton(addEntitlements);
    }

    public void adminInputEmployeeName(String fullName) throws InterruptedException {
        inputText(employeeName, fullName);
        enterInTextBox(employeeName);
    }

    public void adminSelectLeaveType(String typeLeave) throws InterruptedException {
        selectOption(leaveType, typeLeave);
    }

    public void adminInputLeaveBalance(String balance) throws InterruptedException {
        inputText(entitlementsBalance, balance);
    }

    public void clickButtonSave() throws InterruptedException{
        clickButton(btnSave);
    }

    public void employeeGoToLeavePage()throws InterruptedException{
        clickButton(menuLeave);
        clickButton(applyLeave);
    }

    public void employeeSelectLeaveType(String typeLeave) throws InterruptedException{
        selectOption(employeeLeavetype, typeLeave);
    }

    public void employeeSetFromDate(String from) throws InterruptedException{
        clearTextBox(employeeLeaveFrom);
        inputText(employeeLeaveFrom, from);
        enterInTextBox(employeeLeaveFrom);
    }

    public void employeeSetToDate(String to) throws InterruptedException{
        clearTextBox(employeeLeaveTo);
        inputText(employeeLeaveTo, to);
        enterInTextBox(employeeLeaveTo);
    }

    public void employeeInputComment(String comment) throws InterruptedException{
        inputText(employeeLeaveComment, comment);
    }

    public void clickApplyButton() throws InterruptedException{
        clickButton(btnApply);
    }

    public void userSeeErrorMessage() throws InterruptedException{
        waitUntilElementIsVisible(errorMessage);
    }

}
