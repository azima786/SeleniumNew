@tag
Feature: Error Validation

    @tag2
    Scenario Outline: Positive Test of Submitting the order
        Given I landed on Ecomerce page
        When Logged in with username <name> and password <password>
        Then "Incorrect email or password." message is displayed

        Examples:
            | name            | password    |
            | ak123@gmail.com | Abc$123456$ |

