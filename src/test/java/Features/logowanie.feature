Feature: Logowanie do aplikacji

  Jako użytkownik chcę mieć możliwość zalogowania się do aplikacji, aby móc skorzystać z zaawansowanych funckji systemu


  Scenario: Poprawne logowanie do aplikacji
    Given Uzytkownik wpisuje adres https://the-internet.herokuapp.com/login
    When Uzytkownik wpisuje poprawny login
    And Uzytkownik wpisuje poprawne haslo
    And Uzytkownik klika przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany


  Scenario: Niepoprawne logowanie do aplikacji
    Given Uzytkownik wpisuje adres https://the-internet.herokuapp.com/login
    When Uzytkownik wpisuje poprawny login
    And Uzytkownik wpisuje niepoprawne haslo
    And Uzytkownik klika przycisk Login
    Then Uzytkownik nie zostal poprawnie zalogowany


  Scenario: Poprawne logowanie do aplikacji (druga wersja)
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje "tomsmith" w pole username
    And Uzytkownik wpisuje "SuperSecretPassword!" w pole password
    And Uzytkownik klika przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany


  Scenario: Niepoprawne logowanie do aplikacji (druga wersja)
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje "tomsmith" w pole username
    And Uzytkownik wpisuje "blablabla!" w pole password
    And Uzytkownik klika przycisk Login
    Then Uzytkownik nie zostal poprawnie zalogowany


  Scenario: Niepoprawne logowanie do aplikacji (druga wersja)
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje "tomsmith" w pole username
    And Uzytkownik wpisuje " " w pole password
    And Uzytkownik klika przycisk Login
    Then Uzytkownik nie zostal poprawnie zalogowany

    @now
  Scenario Outline: Niepoprawne logowanie
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje <nazwaUzytkownika> w pole username
    And Uzytkownik wpisuje <haslo> w pole password
    And Uzytkownik klika przycisk Login
    Then Uzytkownik nie zostal poprawnie zalogowany

    Examples:
      | nazwaUzytkownika | haslo  |
      | tomsmith         | blabla |
      | tomsmith         | aaa    |