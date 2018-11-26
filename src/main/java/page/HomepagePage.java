package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomepagePage extends BasePage {

    public HomepagePage(WebDriver driver) {
        super(driver);
    }

    public HomepagePage scrollDownToNews(){
        scrollDownToElement(By.className("river__title"));
        return this;
    }

    public List<WebElement> getAllNews(){
        List<WebElement> news = waitAndReturnElements(By.className("post-block"));
        return news;
    }

    public boolean isAllNewsHaveAuthor(List<WebElement> news){
        boolean isAllNewsHaveAuthor = true;
        for(int i=0; i<news.size()-1; i++) {
            try {
                if (!news.get(i).getText().contains("Sponsor") && !news.get(i).getText().contains("Sign up"))
                    news.get(i).findElement(By.className("river-byline__authors"));
                if (i < news.size()-2)
                    scrollDownToElement(news.get(i+1));
                Thread.sleep(1000);
            }catch (Exception ex){
                isAllNewsHaveAuthor = false;
                break;
            }
        }
        return isAllNewsHaveAuthor;
    }

    public boolean isAllNewsHaveImage(List<WebElement> news){
        boolean isAllNewsHaveImage = true;

        for (int i=0; i<news.size()-1; i++){
            try {
                if (!news.get(i).getText().contains("Sponsor") && !news.get(i).getText().contains("Sign up"))
                    news.get(i).findElement(By.className("post-block__media"));
                if (i < news.size()-2)
                        scrollDownToElement(news.get(i+1));
                Thread.sleep(1000);
            } catch (Exception ex) {
                isAllNewsHaveImage = false;
                break;
            }
        }
        return isAllNewsHaveImage;
    }

    public NewsDetailPage clickFirstNews(){
        getAllNews().get(0).click();
        return new NewsDetailPage(driver);
    }
}