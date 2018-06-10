Feature: 

  @Relay
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