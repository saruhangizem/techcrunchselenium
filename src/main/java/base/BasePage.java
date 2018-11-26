package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private int TIME_OUT_LONG;
    private int TIME_OUT_SHORT;
    private int TIME_OUT_MEDIUM;

    public BasePage(WebDriver driver){
        this.driver = driver;
        TIME_OUT_LONG = 30;
        TIME_OUT_MEDIUM = 15;
        TIME_OUT_SHORT = 5;
    }

    public void scrollDownToElement(By selector){
        WebElement element = driver.findElement(selector);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollDownToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement waitAndReturnElement(By selector){
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_LONG);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return element;
    }

    public List<WebElement> waitAndReturnElements(By selector){
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_LONG);
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
        return elements;
    }
}