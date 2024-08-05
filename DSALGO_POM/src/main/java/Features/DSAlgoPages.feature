
@AlgoPages

Feature: DSAlgo Page Navigation

Background:
		Given User already logged in to DSAlgo Home Page with "ac168" and "Algo@168"
 
Scenario Outline: Access DataStructures Page
    ## https://dsportalapp.herokuapp.com/home
    When User hit DataStructures Page
    Then User should see the following text:
		|Data Structures-Introduction |

Scenario Outline: Access Array Page
    When User hit Array Page
    Then User should see the following text:
		|Array											  |

 
Scenario Outline: Access Linked List Page
    When User hit Linked List Page
    Then User should see the following text:   
		|Linked List								  |    
    
        Examples: 
      | loginname  | password |
			| ac168      | Algo@168 |

			
			 
 			