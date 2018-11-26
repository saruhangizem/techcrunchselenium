package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import page.HomepagePage;
import java.util.List;

public class HomepageTest extends BaseTest {

    @Test
    public void doesNewsHaveImageAndAuthor(){
        HomepagePage homepage = new HomepagePage(driver);
        List<WebElement> news  = homepage.scrollDownToNews().getAllNews();
        boolean isAllNewsHaveAuthor = homepage.isAllNewsHaveAuthor(news);
        boolean isAllNewsHaveImage = homepage.isAllNewsHaveImage(news);

        Assert.assertTrue("News do not have image or author.",isAllNewsHaveAuthor && isAllNewsHaveImage);
    }
}