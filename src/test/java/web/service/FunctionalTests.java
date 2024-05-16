package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionalTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Set path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\narwa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginPage() {
        driver.get("http://localhost:8080/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement dob = driver.findElement(By.id("dob"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter valid credentials
        username.sendKeys("vishal");
        password.sendKeys("vishal_pass");
        dob.sendKeys("11-15-1997");

        submitButton.click();

        // Verify redirection to q1 page
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void testQ1Page() {
        driver.get("http://localhost:8080/q1");

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter valid answers
        number1.sendKeys("5");
        number2.sendKeys("3");
        result.sendKeys("8");

        submitButton.click();

        // Verify redirection to q2 page
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ1PageWrongAnswer() {
        driver.get("http://localhost:8080/q1");

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter wrong answer
        number1.sendKeys("5");
        number2.sendKeys("3");
        result.sendKeys("7");

        submitButton.click();

        // Verify redirection back to q1 page with error message
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        WebElement errorMessage = driver.findElement(By.cssSelector("div"));
        Assert.assertEquals("Wrong answer, try again.", errorMessage.getText());
    }

    @Test
    public void testQ1PageEmptyValues() {
        driver.get("http://localhost:8080/q1");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Click submit button without entering any values
        submitButton.click();

        // Verify redirection back to q1 page with error message
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        WebElement errorMessage = driver.findElement(By.cssSelector("div"));
        Assert.assertEquals("All fields are required.", errorMessage.getText());
    }

    @Test
    public void testQ1PageInvalidNumbers() {
        driver.get("http://localhost:8080/q1");

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter invalid non-numeric values
        number1.sendKeys("abc");
        number2.sendKeys("xyz");
        result.sendKeys("123");

        submitButton.click();

        // Verify redirection back to q1 page with error message
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        WebElement errorMessage = driver.findElement(By.cssSelector("div"));
        Assert.assertEquals("Enter valid numbers.", errorMessage.getText());
    }
    
    @Test
    public void testQ2Page() {
        driver.get("http://localhost:8080/q2");

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter valid answers
        number1.sendKeys("10");
        number2.sendKeys("5");
        result.sendKeys("5");

        submitButton.click();

        // Verify redirection to q3 page
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
    }

    @Test
    public void testQ2PageWrongAnswer() {
        driver.get("http://localhost:8080/q2");

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter wrong answer
        number1.sendKeys("10");
        number2.sendKeys("5");
        result.sendKeys("6");

        submitButton.click();

        // Verify redirection back to q2 page with error message
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        WebElement errorMessage = driver.findElement(By.cssSelector("div"));
        Assert.assertEquals("Wrong answer, try again.", errorMessage.getText());
    }

    @Test
    public void testQ2PageEmptyValues() {
        driver.get("http://localhost:8080/q2");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Click submit button without entering any values
        submitButton.click();

        // Verify redirection back to q2 page with error message
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        WebElement errorMessage = driver.findElement(By.cssSelector("div"));
        Assert.assertEquals("All fields are required.", errorMessage.getText());
    }

    @Test
    public void testQ2PageInvalidNumbers() {
        driver.get("http://localhost:8080/q2");

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter invalid non-numeric values
        number1.sendKeys("abc");
        number2.sendKeys("xyz");
        result.sendKeys("123");

        submitButton.click();

        // Verify redirection back to q2 page with error message
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        WebElement errorMessage = driver.findElement(By.cssSelector("div"));
        Assert.assertEquals("Enter valid numbers.", errorMessage.getText());
    }
    
    @Test
    public void testQ3Page() {
        driver.get("http://localhost:8080/q3");

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter valid answers
        number1.sendKeys("4");
        number2.sendKeys("3");
        result.sendKeys("12");

        submitButton.click();

        // Verify redirection to success page
        Assert.assertTrue(driver.getCurrentUrl().contains("/success"));
    }

    @Test
    public void testQ3PageWrongAnswer() {
        driver.get("http://localhost:8080/q3");

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter wrong answer
        number1.sendKeys("4");
        number2.sendKeys("3");
        result.sendKeys("11");

        submitButton.click();

        // Verify redirection back to q3 page with error message
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        WebElement errorMessage = driver.findElement(By.cssSelector("div"));
        Assert.assertEquals("Wrong answer, try again.", errorMessage.getText());
    }

    @Test
    public void testQ3PageEmptyValues() {
        driver.get("http://localhost:8080/q3");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Click submit button without entering any values
        submitButton.click();

        // Verify redirection back to q3 page with error message
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        WebElement errorMessage = driver.findElement(By.cssSelector("div"));
        Assert.assertEquals("All fields are required.", errorMessage.getText());
    }

    @Test
    public void testQ3PageInvalidNumbers() {
        driver.get("http://localhost:8080/q3");

        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Enter invalid non-numeric values
        number1.sendKeys("abc");
        number2.sendKeys("xyz");
        result.sendKeys("123");

        submitButton.click();

        // Verify redirection back to q3 page with error message
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        WebElement errorMessage = driver.findElement(By.cssSelector("div"));
        Assert.assertEquals("Enter valid numbers.", errorMessage.getText());
    }
    
    @Test
    public void testCompleteMathQuiz() {
        // Navigate to login page
        driver.get("http://localhost:8080/login");

        // Fill login form with correct credentials
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement dob = driver.findElement(By.id("dob"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));

        username.sendKeys("vishal");
        password.sendKeys("vishal_pass");
        dob.sendKeys("11-15-1997");
        loginButton.click();

        // Verify redirection to Q1 page
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));

        // Fill Q1 form with correct values
        WebElement number1 = driver.findElement(By.id("number1"));
        WebElement number2 = driver.findElement(By.id("number2"));
        WebElement result = driver.findElement(By.id("result"));
        WebElement nextButton1 = driver.findElement(By.cssSelector("input[type='submit']"));

        number1.sendKeys("5");
        number2.sendKeys("3");
        result.sendKeys("8");
        nextButton1.click();

        // Verify redirection to Q2 page
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));

        // Fill Q2 form with correct values
        WebElement number1_q2 = driver.findElement(By.id("number1"));
        WebElement number2_q2 = driver.findElement(By.id("number2"));
        WebElement result_q2 = driver.findElement(By.id("result"));
        WebElement nextButton2 = driver.findElement(By.cssSelector("input[type='submit']"));

        number1_q2.sendKeys("7");
        number2_q2.sendKeys("3");
        result_q2.sendKeys("4");
        nextButton2.click();

        // Verify redirection to Q3 page
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));

        // Fill Q3 form with correct values
        WebElement number1_q3 = driver.findElement(By.id("number1"));
        WebElement number2_q3 = driver.findElement(By.id("number2"));
        WebElement result_q3 = driver.findElement(By.id("result"));
        WebElement nextButton3 = driver.findElement(By.cssSelector("input[type='submit']"));

        number1_q3.sendKeys("4");
        number2_q3.sendKeys("3");
        result_q3.sendKeys("12");
        nextButton3.click();

        // Verify redirection to success page
        Assert.assertTrue(driver.getCurrentUrl().contains("/success"));
    }


}

