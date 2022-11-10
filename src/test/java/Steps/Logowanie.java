package Steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Logowanie {

    static WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        System.out.println("Uruchomienie przed wszystkimi scenariuszami testowymi");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before
    public void before() {
        System.out.println("Uruchomienie przed każdym scenariuszem testowym");
    }

    @Given("Uzytkownik otwiera przegladarke")
    public void testUzytkownikOtwieraPrzegladarke() {
        System.out.println("Uzytkownik otworzyl przegladarke");
        // System.setProperty("webdriver.chrome.driver", "c:/chromedriver/chromedriver107.exe");
    }

    @Given("Uzytkownik wpisuje adres https:\\/\\/the-internet.herokuapp.com\\/login")
    public void uzytkownik_wpisuje_adres_https_the_internet_herokuapp_com_login() {
        System.out.println("Uzytkownik wpisuje adres strony");
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    // Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    @Given("Uzytkownik wpisuje adres {string}")
    public void uzytkownik_wpisuje_adres(String url) {
        driver.navigate().to(url);
    }

    // When Uzytkownik wpisuje "tomsmith" w pole username
    @When("Uzytkownik wpisuje {string} w pole username")
    public void uzytkownik_wpisuje_w_pole_username(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    // When Uzytkownik wpisuje "SuperSecretPassword!" w pole password
    @When("Uzytkownik wpisuje {string} w pole password")
    public void uzytkownik_wpisuje_w_pole_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("Uzytkownik wpisuje poprawny login")
    public void uzytkownik_wpisuje_poprawny_login() {
        System.out.println("Uzytkownik wpisuje poprawny login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
    }

    @When("Uzytkownik wpisuje poprawne haslo")
    public void uzytkownik_wpisuje_poprawne_haslo() {
        System.out.println("Uzytkownik wpisuje poprawne haslo");
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("SuperSecretPassword!");
    }

    @When("Uzytkownik klika przycisk Login")
    public void uzytkownik_klika_przycisk_login() {
        System.out.println("Uzytkownik klika przycisk login");
        driver.findElement(By.tagName("button")).click();
    }

    @Then("Uzytkownik zostal poprawnie zalogowany")
    public void uzytkownik_zostal_poprawnie_zalogowany() {
        System.out.println("Uzytkownik zostaje poprawnie zalogowany");
        Assert.assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());
    }

    @When("Uzytkownik wpisuje niepoprawne haslo")
    public void uzytkownik_wpisuje_niepoprawne_haslo() {
        System.out.println("Uzytkownik wpisuje niepoprawne haslo");
        driver.findElement(By.id("password")).sendKeys("aaa");
    }

    @Then("Uzytkownik nie zostal poprawnie zalogowany")
    public void uzytkownik_nie_zostal_poprawnie_zalogowany() {
        System.out.println("Uzytkownik nie zostal zalogowany");
        Assert.assertEquals("https://the-internet.herokuapp.com/login",driver.getCurrentUrl());
    }

    @When("^Uzytkownik wpisuje (.+) w pole username$")
    public void uzytkownik_wpisuje_w_pole_username2(String nazwauzytkownika) {
        driver.findElement(By.id("username")).sendKeys(nazwauzytkownika);
    }

    @And("^Uzytkownik wpisuje (.+) w pole password$")
    public void uzytkownik_wpisuje_w_pole_password2(String haslo) {
        driver.findElement(By.id("password")).sendKeys(haslo);
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }

}
