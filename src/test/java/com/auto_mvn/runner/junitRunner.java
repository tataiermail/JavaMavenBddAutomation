package com.auto_mvn.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue={"stepDefinition"})
public class junitRunner {

}
