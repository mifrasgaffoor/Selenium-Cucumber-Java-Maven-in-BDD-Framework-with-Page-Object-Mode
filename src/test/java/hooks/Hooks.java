package hooks;

import io.cucumber.java.*;

public class Hooks {

    @BeforeStep
    public  void  beforeStep(Scenario scenario){

        System.out.println("yes works");
    }

    @AfterStep
    public  void  afterStep(Scenario scenario){
        System.out.println("no works");
    }

    @Before
    public  void  beforeScenario(Scenario scenario){
        String name = scenario.getName();
        System.out.println(name);
    }


    @After
    public  void  afterScenario(Scenario scenario){
        boolean failed = scenario.isFailed();
        System.out.println(failed);
    }
}
