Feature: User Authentication
  As a user
  I want to be able to authenticate myself
  So that I can access my account

  Scenario: Sucessful login
    Given a registered user with userid "Testuser" and password "Testpassword123"


  Scenario Outline: Login with multiple crendentials
    Given I am registered user with username "<username>" and with password "<password>"

    Examples:
      |username|password|
      |user123|password@123|
      |user345|password@234|

  Scenario: Login with dataTable as list
    Given the user creds in the datatable
      |datatableuser1|password@123|
      |datatableuser2|password@345|

  Scenario: Login with dataTable as map
    Given the user enters the creds using map
      |username|password|
      |mapuser1|mappassword1|
      |mapuser2|mappassword2|


  Scenario: Login with JSON data
    Given I am using JSON data
     """
     {
"users":[{
         "name":"John",
         "age":"25"
        },{ "name":"Doe",
            "age":"27"
        }
        ]
}
     """