
Feature: DataStructures Page Navigation

		##Given User already logged in to DSAlgo Home Pagew with "ac168" and "Algo@168"
 
Scenario Outline: Access DataStructures Page
		Given Login to DsAlgo Application with "<loginname>" and "<password>"
    # https://dsportalapp.herokuapp.com/home
    When User click DataStructures Page
    Then User see the following text:
	  |Data Structures-Introduction |
#Scenario: Access time-complexity
    When User hit time-complexity
    Then User should see the following text:
		|Time Complexity						  |
#Scenario Outline: Access Try here under time-complexity
    When User hit Try here
    Then User should see the Run button 
#Scenario Outline: Goback to Home Page
    When User hit Back on Browser
    Then User should see the SignOut option 
 

 Examples: 
      | loginname  | password |
			| ac168      | Algo@168 |
			
			
	
 
			 
 			