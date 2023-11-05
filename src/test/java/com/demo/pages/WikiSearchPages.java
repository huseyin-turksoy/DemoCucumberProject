package com.demo.pages;

import com.demo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPages {

    /** To be able to apply POM (Page Object Model) first we need to create constructor
    with page factory class then we can use FindBy notation**/
    public WikiSearchPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "span[class=\"central-textlogo__image sprite svg-Wikipedia_wordmark\"]")
    public WebElement pageHeader;

    @FindBy(css = "input[id=\"searchInput\"]")
    public WebElement searchBox;

    @FindBy(css = "span[class=\"mw-page-title-main\"]")
    public WebElement pageInnerTitle;




}
