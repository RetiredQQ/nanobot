@unit-test
Feature: parsing main screen

  Scenario Outline: search attack button
    Given screenshot saved as <imagefile>
    When searching attack button
    Then attack button found at <coords>

    Examples:
      | imagefile                                      | coords   |
      | classpath:/features/img/main_1435575631326.png | null     |
      | classpath:/features/img/main_1435601238653.png | [62,643] |
      | classpath:/features/img/main_1435603470723.png | [62,643] |


  Scenario Outline: search full gold mine
    Given screenshot saved as <imagefile>
    When searching full gold mine
    Then full gold mine found at <coords>

    Examples:
      | imagefile                                      | coords    |
      | classpath:/features/img/main_1435696574573.png | [449,436] |
      | classpath:/features/img/main_1435698446657.png | [261,225] |
      | classpath:/features/img/main_1435699320137.png | [618,281] |
      | classpath:/features/img/main_1435700312519.png | [440,162] |
      | classpath:/features/img/main_1435701087138.png | [308,401] |


  Scenario Outline: search full elixir collector
    Given screenshot saved as <imagefile>
    When searching full elixir collector
    Then full elixir collector found at <coords>

    Examples:
      | imagefile                                      | coords    |
      | classpath:/features/img/main_1435603470723.png | [458,193] |
      | classpath:/features/img/main_1435699887290.png | [289,195] |
      | classpath:/features/img/main_1435700716498.png | [279,370] |
      | classpath:/features/img/main_1435701555074.png | [420,406] |


  Scenario Outline: search full dark elixir drill
    Given screenshot saved as <imagefile>
    When searching full dark elixir drill
    Then full dark elixir drill found at <coords>

    Examples:
      | imagefile                                      | coords    |
      | classpath:/features/img/main_1435601238653.png | [326,325] |
      | classpath:/features/img/main_1435603470723.png | null      |


  Scenario Outline: check if rax is full
    Given screenshot saved as <imagefile>
    When checking if camps are full
    Then check is <check>

    Examples:
      | imagefile                                       | check |
      | classpath:/features/img/train_1435769837116.png | false |
      | classpath:/features/img/train_1435772811358.png | true  |
