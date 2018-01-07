package Feature;

 import org.junit.runner.RunWith;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.junit4.Karate;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.util.*;

import org.junit.Test;


public class TestRUnner {
    @Test
    public void testCallingClasspathFeatureFromJava() {
        Map<String, Object> args = new HashMap();
        args.put("name", "World");
        Map<String, Object> result = CucumberRunner.runClasspathFeature("Feature/getStates.feature", args, true);
        //assertEquals("Hello World", result.get("greeting"));
} 
}