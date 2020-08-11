@ExampleMicronaut
Feature: Find Owner By Name
	As a user, I want to get data owner by name, so that I can check owner details
	
	@Positive
  Scenario Outline: [Positive Test] - Find Owner By Name
    Given API is ready
    When I request find owner by name <owner_name>
    Then get response code <response_code>
    And The owner details as below:
      | owner_name   | owner_age   |
      | <owner_name> | <owner_age> |

    Examples: 
      | response_code | owner_name 	| owner_age |
      | 200						| Fred				| 45    	  |
      |	200						| Barney    	| 40      	|
  
  @Negative    
	Scenario Outline: [Negative Test] - Find Owner By Name
    Given API is ready
    When I request find owner by name <owner_name>
    Then get response code <response_code>
    
    Examples: 
      | response_code | owner_name 	| 
      | 404						| John				|
      |	404						| Rob	    		|