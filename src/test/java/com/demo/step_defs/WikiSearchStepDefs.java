package com.demo.step_defs;

import com.demo.pages.WikiSearchPages;
import com.demo.utils.ConfigurationReader;
import com.demo.utils.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikiSearchStepDefs {

    WikiSearchPages wiki = new WikiSearchPages();


    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {

        String webPage = ConfigurationReader.getProperty("url");
        try {
            //navigate to page
            Driver.getDriver().get(webPage);
            // to assert successfully navigated to the page
            Assert.assertTrue(wiki.pageHeader.isDisplayed());

        }catch (Exception e){
            System.out.println(" Redirecting to the page.... ");
            Driver.getDriver().get(webPage);
        }


    }
    @When("User searches {string} in search box")
    public void user_searches_in_search_box(String searchedKeyword) {
        //pass the related keyword into the search box and press ENTER
        wiki.searchBox.sendKeys(searchedKeyword+ Keys.ENTER);

    }
    @When("User asserts searched {string} is shown")
    public void user_asserts_searched_is_shown(String assertedKeyword) {

        String innerTitle = wiki.pageInnerTitle.getText();
        Assert.assertEquals(assertedKeyword.toLowerCase(),innerTitle.toLowerCase());

    }


}
