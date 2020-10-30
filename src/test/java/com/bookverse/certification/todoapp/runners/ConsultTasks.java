package com.bookverse.certification.todoapp.runners;

import static cucumber.api.SnippetType.CAMELCASE;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/consult_tasks.feature",
    glue = "com.bookverse.certification.todoapp.stepdefinitions",
    snippets = CAMELCASE)
public class ConsultTasks {

}
