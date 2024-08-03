Feature: Login Feature
  Scenario: Verify Elements in Landing Page and HomePage.
    Given The user is in Landing Page
    When Verify Title "Numpy Ninja".
    Then page h1-tag is "Preparing for the Interviews"and paragraph-tag is "You are at the right place".
    And get-started button text is "Get Started".
    When Click [Get Started] button. User navigated to Login page.
    Then [Register] and [Sign in] links are displayed at the top right corner of Login page
    When User Clicks the [Register] link
    Then The Application displays Registration page
    When User clicks [Sign in] link.
    And User enters "Nirvana" and "archanachaya" and clicks Login button
    When User is in HomePage.Get the title of that page
    Then DataStructures Dropdown displayed.
      | dropdown-menu show |
      | Array              |
      | Linked List        |
      | Stack              |
      | Queue              |
      | Tree               |
      | Graph              |

  Scenario Outline: Verify Homepage
    Given The <pane> are displayed with Get Started button.

    Examples: 
      | pane                         |
      | Data Structures-Introduction |
      | Array                        |
      | Linked List                  |
      | Stack                        |
      | Queue                        |
      | Tree                         |
      | Graph                        |
