Feature: Find Pets By Name

  Scenario Outline: [Positive Test] - Find Pets By Name
    Given API is available
    When I request find pet by name <pet_name>
    Then I get response code <response_code>
    And The pet details as below:
      | pet_name   | pet_type   |
      | <pet_name> | <pet_type> |

    Examples: 
      | response_code | pet_name | pet_type |
      | 200						| Dino     | DOG      |
      |	200						| Hoppy    | DOG      |
