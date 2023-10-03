Refer to this for a detailed explanation - http://ghchirp.site/126/

This uses the concept of splitting ScenarioOutline tables into separate Example sections to surround with a setup and teardown method.

Let's try to model an atheletics relay race (4X100m) into a Cucumber scenario. A simple approach would be to repeat steps for each runner, leading to a long scenario with repeation. So how about using a scenariooutline and extracting the common variables, like number of runner and from to end distance marker for each runner. Possibly something similar to below.

    Scenario Outline: 
    Given <runner> runner <state> baton in hand
    When Runner starts running
    Then Runner runs required <distmarker>
    
    Examples: 
      | runner | distmarker | state |
      | First  | 100        | has   |
      | Second | 200        | gets  |
      | Third  | 300        | gets  |
      | Last   | 400        | gets  |
      
Looks pretty good, but it does not take into account that the first runner begins from the start line. Also the last runner crosses the finish line. If these two steps are added to the existing ScenarioOutline, it will not provide the ideal solution. 

    Scenario Outline: 
    Given <runner> runner <state> baton in hand
    When Runner starts running
    Then Runner runs required <distance>
    
    @First
    Examples: 
      | runner | distance | state |
      | First  | 100      | has   |

    Examples: 
      | runner | distance | state |
      | Second | 200      | gets  |
      | Third  | 300      | gets  |

    @Last
    Examples: 
      | runner | distance | state |
      | Last   | 400      | gets  |
      
The Examples table is now split into three, with the first and the last given the tags. Use this tags to run @Before and @After hooks, modelling the unique requirements.

    @Before("@First")
    public void startLine() {
        //First runner is at start line
    }
    
    @After("@Last")
    public void finishLine() {
    	//Last runner crosses finish line
    }
    
 These hooks will then act as setup and teardown methods.
