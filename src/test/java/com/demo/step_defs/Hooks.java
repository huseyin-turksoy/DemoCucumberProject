package com.demo.step_defs;

import com.demo.utils.BrowserUtils;
import com.demo.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @BeforeStep
    public void horizontalLineStart(){
        System.err.println("------------------- START STEP -------------------");
        BrowserUtils.sleep(1);
    }



    @After
    public void tearDown(Scenario scenario){

        //if scenario fails, it takes screenshot
        if (scenario.isFailed()){
            byte[] screenshot = ( (TakesScreenshot) Driver.getDriver() ).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        //for closing the browser
        Driver.closeDriver();
    }



}
