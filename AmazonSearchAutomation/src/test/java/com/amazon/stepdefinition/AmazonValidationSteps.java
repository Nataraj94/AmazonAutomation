package com.amazon.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page_objects.LoginPage;
import page_objects.SearchPage;
import reuseable.BaseClass;
import java.io.IOException;

public class AmazonValidationSteps {

    public WebDriver driver;

    public LoginPage login;
    public SearchPage search;


    @Given("user navigate to url")
    public void user_navigate_to_url() throws IOException {

        driver = BaseClass.browserCall();

    }
    @When("User clicks the sign-in button")
    public void user_clicks_the_sign_in_button() {

        driver.findElement(By.xpath("//span[@id='gw-sign-in-button']")).click();
    }
    @When("User enters the valid Login credential and click sign-in button")
    public void user_enters_the_valid_login_credential() throws IOException {
        login = new LoginPage(driver);

        login.enterUserName();
        login.continueButton();
        login.enterPassWord();
        login.ClickLogin();

    }
    @Then("User clicks the sign-out button and navigate to homepage")
    public void user_clicks_the_sign_in_button_and_navigate_to_homepage() {

        WebElement accountInfo = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions accountHover = new Actions(driver);
        accountHover.clickAndHold(accountInfo).build().perform();
        driver.findElement(By.linkText("Sign Out")).click();

    }

    @Then("verify weather the user sign-out successfully")
    public void verifySignOut(){

        String title = driver.getTitle();
        Assert.assertEquals(title,"Amazon Sign-In");

    }

    @When("User enters value in search bar and click the item")
    public void user_enters_value_in_search_bar_and_click_the_item() {

        search = new SearchPage(driver);
        search.SearchBar();
        search.SearchButton();

    }
    @When("user can select the product and add to cart")
    public void user_can_select_the_product_and_add_to_cart() {

        search.SelectProduct();
        search.AddToCart();

    }
    @Then("User verify the selected product and remove product from cart")
    public void user_verify_the_selected_product_and_remove_product_from_cart() {


        search.GoToCart();
        //String CartMessage = driver.findElement(By.xpath("//div[@class='a-box a-alert-inline a-alert-inline-success sw-atc-message']/following-sibling::span")).getText();
        //Assert.assertEquals( "Added to Cart",CartMessage);
        //String AddCartCount = driver.findElement(By.xpath("//div[@id='nav-cart-count-container']/span")).getText();
        //Assert.assertEquals("3",AddCartCount);

        search.RemoveProduct();

    }

}
