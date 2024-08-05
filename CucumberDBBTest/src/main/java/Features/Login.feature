
Feature: DSAlgo Login
  @Login
  Scenario Outline: Login to DsAlgo Application
    Given User is on DSAlgo Home Page
    ## https://dsportalapp.herokuapp.com/home
    When User enter "<loginname>" and "<password>" and hit Signin
    Then User should login to the application

    Examples: 
      | loginname  | password |
			| ac168      | Algo@168 |
			
			
	