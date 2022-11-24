package com.azulcrm.runners;

import com.azulcrm.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "pretty",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/azulcrm/step_definitions",
        dryRun = false,
        tags = "@hatice",
        publish = true

)
public class RoadRunner {

}
