Feature: Stack page
Background: Verify Elements in Landing Page and HomePage.
    Given The user is in Landing Page
    When Verify Title "Numpy Ninja".
    Then page h1-tag is "Preparing for the Interviews" and paragraph-tag is "You are at the right place".
    And get-started button text is "Get Started".
    When Click [Get Started] button. User navigated to Login page.
    Then [Register] and [Sign in] links are displayed at the top right corner of Login page
    When User Clicks the [Register] link
    Then The Application displays Registration page
    When User clicks [Sign in] link.
    And User enters "Nirvana" and "archanachaya" and clicks Login button
    When User is in HomePage.Get the title of that page
    Then DataStructures Dropdown displayed.
      

   Scenario: Verify "Operations in Stack" Link in Stack page
    Given User is in Home page.
    When User clicks "Stack" pane with Get Started button which is Enabled.
    Then User navigated to Stack page and get the Title of that page
    When Stack information is displayed with related Links below.
      | Operations in Stack |
      | Implementation      |
      | Applications        |
      
    When User clicks operations in stack Link.
    Then Application navigated to Operation in Stack Page, Get the title of that page.
    And Operation in Stack page is displayed with information and "Try here>>>" button.
    When user clicks "Try here>>" button.
    Then Application navigated to tryEditor page.
    When User enters <valInval> code in Editor page and clicks [Run] button.
    Then Expected output is displayed.
    
   Examples:
    |valInval|
    |valid|
    |Invalid|

  #Scenario: Verify "Implementation" Link in Stack page.
    #Given User is in Home page.
    #When User clicks "Get Started" button in Stack which is Enabled.
    #Then User navigated to Stack page and get the Title of that page
    #When Stack information is displayed with related Links below.
      #| Operations in Stack |
      #| Implementation      |
      #| Applications        |
      #
    #When User clicks Implementation Link.
    #Then Application navigated to Implementation Page, Get the title of that page.
    #And Implementation page is displayed with information and "Try here>>>" button.
    #When user clicks "Try here>>" button.
    #Then Application navigated to tryEditor page.
    #When User enters valid code in Editor page and clicks [Run] button.
    #Then Expected output is displayed.
    #When User enters Invalid code in Editor page and clicks [Run] button.
    #Then Error popup is displayed.
#
  #Scenario: Verify Applications Link in Stack page.
    #Given User is in Home page.
    #When User clicks "Get Started" button in Stack which is Enabled.
    #Then User navigated to Stack page and get the Title of that page
    #When Stack information is displayed with related Links below.
      #| Operations in Stack |
      #| Implementation      |
      #| Applications        |
      #
    #When User clicks Applications Link.
    #Then Application navigated to Applications of Stack Page, Get the title of that page.
    #And Applications is displayed with information and "Try here>>>" button.
    #When user clicks "Try here>>" button.
    #Then Application navigated to tryEditor page.
    #When User enters valid code in Editor page and clicks [Run] button.
    #Then Expected output is displayed.
    #When User enters Invalid code in Editor page and clicks [Run] button.
    #Then Error popup is displayed.
#
  #Scenario: Verify "Practice Questions" Link in Stack page.
    #Given User is in Home page.
    #When User clicks "Get Started" button in Stack which is Enabled.
    #Then User navigated to Stack page and get the Title of that page
    #When Stack information is displayed with related Links below.
      #| Operations in Stack |
      #| Implementation      |
      #| Applications        |
     #
    #When User clicks Practice Questions Link.
    #Then Questions are Expected in Practice Questions page.
