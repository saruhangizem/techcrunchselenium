package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.HomepagePage;
import page.NewsDetailPage;

public class NewsDetailTest extends BaseTest {

    @Test
    public void newsDetailTitleAsSameAsWindowTitle(){
        HomepagePage homepage = new HomepagePage(driver);
        NewsDetailPage newsDetail = new NewsDetailPage(driver);

        homepage.scrollDownToNews().clickFirstNews();
        String detailTitle  = newsDetail.getNewsTitle();
        String windowTitle = driver.getTitle();
        windowTitle = windowTitle.replace(" | TechCrunch","");
        boolean areTitlesSame = detailTitle.contains(windowTitle);

        Assert.assertTrue("Different titles.", areTitlesSame);
    }

    @Test
    public void linksControl(){
        HomepagePage homepage = new HomepagePage(driver);

        boolean isNewsWithLinks = homepage.scrollDownToNews().clickFirstNews().scrollDownToHrefLink().areLinksHere();

         Assert.assertTrue("Page does not have any links", isNewsWithLinks);
    }
}