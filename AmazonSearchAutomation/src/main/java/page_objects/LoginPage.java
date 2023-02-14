package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reuseable.BaseClass;


import java.io.IOException;


public class LoginPage extends BaseClass {

    public static WebDriver driver;


    By txt_username = By.name("email");
    By txt_password = By.name("password");
    By btn_continue = By.id("continue");
    By btn_login = By.id("signInSubmit");



    public LoginPage(WebDriver driver){

        this.driver=driver;

    }

    public void enterUserName() throws IOException {

        driver.findElement(txt_username).sendKeys(prop.getProperty("Username"));


    }
    public void enterPassWord() throws IOException {

        driver.findElement(txt_password).sendKeys(prop.getProperty("Password"));

    }
    public void continueButton(){

        driver.findElement(btn_continue).click();
    }
    public void ClickLogin(){

        driver.findElement(btn_login).click();
    }
}
