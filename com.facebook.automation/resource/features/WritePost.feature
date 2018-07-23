Feature: All

  Scenario Outline: Write post on Facebook
    Given the "<Browser>" and navigate to the web site facebook
    And Make the "<Login>"
    When Validate the "<Name>" in Main menu
    When Write a new POST with content "<Input>"
    Then Make the logout on facebook and validate the text "<Logout>".

    Examples:
      | Browser | Login                |  Name               | Input                      | Logout                  |
      | Firefox | 11972418260          |   Mateus Rossetti   | Bom Dia meus Amigos!       | entre ou cadastre-se    |
      | Chrome  | 11972418260          |   Mateus Rossetti   | Boa Tarde meus Amigos!     | entre ou cadastre-se    |


  Scenario Outline: Validated post created on Facebook
    Given the "<Browser>" and navigate to the web site facebook
    And Make the "<Login>"
    When Validate the "<Name>" in Main menu
    When navigate to the web site "https://developers.facebook.com/tools/explorer/?method=GET"
    And Get new token
    Then Validate if the post was created "<Input>" on facebook
    And Close browser

    Examples:
      | Browser | Login                | Name               | Input                      | Logout                  |
      | Firefox | 11972418260          |  Mateus Rossetti   | Bom Dia meus Amigos!       | entre ou cadastre-se    |
      | Chrome  | 11972418260          |  Mateus Rossetti   | Boa Tarde meus Amigos!     | entre ou cadastre-se    |


  Scenario Outline: Delete post on Facebook
    Given the "<Browser>" and navigate to the web site facebook
    And Make the "<Login>"
    When Validate the "<Name>" in Main menu
    When Deletar a nova postagem no facebook e validar a exclusao "<Input>".
    Then Make the logout on facebook and validate the text "<Logout>".

    Examples:
      | Browser | Login                | Name               | Input                      | Logout                  |
      | Firefox | 11972418260          |  Mateus Rossetti   | Bom Dia meus Amigos!       | entre ou cadastre-se    |
      | Chrome  | 11972418260          |  Mateus Rossetti   | Boa Tarde meus Amigos!     | entre ou cadastre-se    |

  Scenario Outline: Validated post deleted on Facebook
    Given the "<Browser>" and navigate to the web site facebook
    And Make the "<Login>"
    When Validate the "<Name>" in Main menu
    When navigate to the web site "https://developers.facebook.com/tools/explorer/?method=GET"
    And Get new token
    Then Validate if the post has been deleted "<Input>" on facebook
    And Close browser

    Examples:
          | Browser | Login                | Name               | Input                      | Logout                  |
          | Firefox | 11972418260          |  Mateus Rossetti   | Bom Dia meus Amigos!       | entre ou cadastre-se    |
          | Chrome  | 11972418260          |  Mateus Rossetti   | Boa Tarde meus Amigos!     | entre ou cadastre-se    |
