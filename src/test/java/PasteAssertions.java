import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PasteAssertions {

    private WebDriver driver;

    public PasteAssertions(WebDriver driver) {

        this.driver = driver;
    }

    public void assertTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle + " - Pastebin.com", actualTitle);
    }

    public void assertSyntaxHighlighting(String expectedSyntaxHighlighting) {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedSyntaxHighlighting.toLowerCase()));
    }

    public void assertCode(String expectedCode) {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedCode));
    }
}
