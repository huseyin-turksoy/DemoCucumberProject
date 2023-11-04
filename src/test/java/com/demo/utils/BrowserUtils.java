package com.demo.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    //------------------------------- VARIABLES -------------------------------






    //------------------------------- METHODS -------------------------------

    /**
     * accepts seconds as parameter, waits for given duration
     * @param seconds
     */
    public static void sleep(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void click(WebElement element){
        int numAttempts = 5;
        int attempts = 0;

        while (attempts < numAttempts) {
            try {
                element.click();
                //System.out.println("Element clicked successfully");
                break; // If the click is successful, exit the loop
            } catch (WebDriverException e) {
                System.out.println("Attempt #" + (attempts + 1) + ": Click failed");
            }
            attempts++;
        }

        if (attempts == numAttempts) {
            throw new RuntimeException("Element could not be clicked after " + attempts + " attempts");
        }
    }



    /**
     * accepts WebElement as parameter, waits for visibility of given WebElement
     * @param element
     */
    public static void waitForVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),25);
        wait.until(ExpectedConditions.visibilityOf(element));
        //System.out.println(elementName + "Element is successfully displayed");
    }

    public static void waitForVisible(By byElement){

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),25);
            wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        } catch (Exception e) {

        }
    }

    public static void waitForInvisibility(By byElement){
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
            System.out.println("The element is removed successfully from page");
//May apply thread sleep for 1 or 2 seconds
        }catch(RuntimeException e){
            throw new RuntimeException("Element couldn't disappear from page");
        }}



    /**
     * accepts WebElement as parameter, waits for clickablity of given WebElement
     * @param element
     */
    public static void waitForClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),25);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForClickable(By element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),25);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }




    /**
     * accepts title as parameter, waits title to be given title
     * @param title
     */
    public static void waitForTitle(String title){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),25);
        wait.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(Driver.getDriver().getTitle(),title);
    }

    public static void waitForTitleToContain(String title){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),25);
        wait.until(ExpectedConditions.titleContains(title));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }


    public static void waitForUrlToContain(String string){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),25);
        wait.until(ExpectedConditions.urlContains(string));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(string));
    }

    public static void checkCheckbox(WebElement checkbox){
        if (checkbox.getAttribute("className").contains("checked")){
            System.out.println("It is already checked!");
        }else {
            click(checkbox);
        }
    }

    public static void uncheckCheckbox(WebElement checkbox){
        if (checkbox.getAttribute("className").contains("checked")){
            click(checkbox);
        }else {
            System.out.println("It is already unchecked!");
        }
    }


}
