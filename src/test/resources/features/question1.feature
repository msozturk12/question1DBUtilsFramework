@db
Feature:
    #Find out the customer id, name, surname, the city
    # and the country of the customers who make the most purchases and how much money they have spent ?

  Scenario Outline: Verify the homework first question's answer with DataBase
    Given :"<customer_id>" "<first_name>" "<last_name>" "<city>" "<country>" "<count>" "<sum>" should match with the result

    Examples:
      | customer_id | first_name | last_name | city                | country       | count | sum    |
      | 148         | Eleanor    | Hunt      | Saint-Denis         | Runion        | 45    | 211.55 |
      | 526         | Karl       | Seal      | Cape Coral          | United States | 42    | 208.58 |
      | 178         | Marion     | Snyder    | Santa Brbara dOeste | Brazil        | 39    | 194.61 |
      | 137         | Rhonda     | Kennedy   | Apeldoorn           | Netherlands   | 38    | 191.62 |
      | 144         | Clara      | Shaw      | Molodetno           | Belarus       | 40    | 189.60 |
