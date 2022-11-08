Feature: Logowanie do aplikacji

  Jako użytkownik chcę mieć możliwość zalogowania się do aplikacji, aby móc skorzystać z zaawansowanych funckji systemu

  Scenario: Poprawne logowanie do aplikacji
    Given Uzytkownik otwiera przegladarke
    And Uzytkownik wpisuje adres https://the-internet.herokuapp.com/login
    When Uzytkownik wpisuje poprawny login
    And Uzytkownik wpisuje poprawne haslo
    And Uzytkownik klika przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany