package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class NewsDetailPage extends BasePage{

    public NewsDetailPage(WebDriver driver) {
        super(driver);
    }

    public String getNewsTitle(){
        String title = waitAndReturnElement(By.className("article__header")).getText();
        return title;
    }

    public boolean areLinksHere(){
       WebElement summeryStart = waitAndReturnElement(By.id("speakable-summary"));
       List<WebElement> href = summeryStart.findElements(By.cssSelector("a"));

       return href.size()>0;
    }

    public NewsDetailPage scrollDownToHrefLink(){
        WebElement summeryStart = waitAndReturnElement(By.id("speakable-summary"));
        scrollDownToElement(summeryStart);
        return this;
    }
}