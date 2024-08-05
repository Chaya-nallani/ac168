
Feature: DSAlgo SignOut
  @SignOut
  Scenario Outline: SignOut of DsAlgo Application
    Given User already logged in to DSAlgo Home Page with "<loginname>" and "<password>"
    ## https://dsportalapp.herokuapp.com/home
    When User hit SignOut
    Then User should SignOut Successfully

    Examples: 
      | loginname  | password |
			| ac168      | Algo@168 |
			
			