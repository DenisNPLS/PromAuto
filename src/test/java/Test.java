import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    private WebDriver driver;

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://www.linux.org.ru");
    }

    @org.junit.jupiter.api.Test
    void shouldTestUpNews() {
        driver.findElement(By.xpath("//a[contains(text(), 'Новости')]")).click();
        String newsText = driver.findElement(By.xpath("//h1[contains(text(),'Новости')]")).getText().trim();
        assertEquals("Новости", newsText);
    }

    @org.junit.jupiter.api.Test
    void shouldTestUpArticles() {
        driver.findElement(By.xpath("//a[contains(text(), 'Статьи')]")).click();
        String articlesText = driver.findElement(By.xpath("//h1[contains(text(),'Статьи')]")).getText().trim();
        assertEquals("Статьи", articlesText);
    }

    @org.junit.jupiter.api.Test
    void shouldTestUpForum() {
        driver.findElement(By.xpath("//a[contains(text(), 'Форум')]")).click();
        String forumText = driver.findElement(By.xpath("//h1[contains(text(),'Технический форум')]")).getText().trim();
        assertEquals("Технический форум", forumText);
    }

    @org.junit.jupiter.api.Test
    void shouldTestUpTracker() {
        driver.findElement(By.xpath("//a[contains(text(), 'Трекер')]")).click();
        String trackerText = driver.findElement(By.xpath("//h1[contains(text(),'Последние сообщения')]")).getText().trim();
        assertEquals("Последние сообщения", trackerText);
    }

    @org.junit.jupiter.api.Test
    void shouldTestUpSearch() {
        driver.findElement(By.xpath("//a[contains(text(), 'Поиск')]")).click();
        String searchText = driver.findElement(By.xpath("//h1[contains(text(),'Поиск по сайту')]")).getText().trim();
        assertEquals("Поиск по сайту", searchText);
    }

    @org.junit.jupiter.api.Test
    void shouldTestRegistration() {
        driver.findElement(By.xpath("//a[contains(text(), 'Регистрация')]")).click();
        String registrationText = driver.findElement(By.xpath("//h1[contains(text(),'Регистрация')]")).getText().trim();
        assertEquals("Регистрация", registrationText);
    }

    @org.junit.jupiter.api.Test //BUG!!
    void shouldTestSignIn() {
        driver.findElement(By.xpath("//a[@id='loginbutton']")).click();
        String signInText = driver.findElement(By.xpath("//*[contains(text(),'Имя: ')]")).getText().trim();
        assertEquals("Имя: ", signInText);
    }

    @org.junit.jupiter.api.Test
    void shouldTestCli() {
        driver.findElement(By.xpath("//a[contains(text(),'GitHub CLI 2.23.0')]")).click();
        String topicText = driver.findElement(By.xpath("//a[contains(text(),'GitHub CLI 2.23.0')]")).getText().trim();
        assertEquals("GitHub CLI 2.23.0", topicText);
    }

    @org.junit.jupiter.api.Test
    void shouldTestLastArticle() {
        driver.findElement(By.xpath("//a[contains(text(),'Midnight Commander')]")).click();
        String articleText = driver.findElement(By.xpath("//a[contains(text(),'Midnight Commander')]")).getText().trim();
        assertEquals("Midnight Commander 4.8.29", articleText);
    }

    @org.junit.jupiter.api.Test
    void shouldTestSurvey() {
        driver.findElement(By.xpath("//a[contains(text(), 'Опрос')]")).click();
        String surveyText = driver.findElement(By.xpath("//h1[contains(text(), 'Голосования')]")).getText().trim();
        assertEquals("Голосования", surveyText);
    }

    @org.junit.jupiter.api.Test
    void shouldTestSurveyWithValue() {
        driver.findElement(By.xpath("//input[@value='26087']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String accessDeniedText = driver.findElement(By.xpath("//*[contains(text(),'Доступ запрещен')]")).getText().trim();
        assertEquals("Доступ запрещен.", accessDeniedText);
    }

}
