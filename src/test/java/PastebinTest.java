import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class PastebinTest {


    public static void main(String[] args) {

        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String syntaxHighlighting = "Bash";
        String pasteExpiration = "10 Minutes";
        String pasteName = "how to gain dominance among developers";

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='qc-cmp2-ui']/div[2]/div/button[2]")))
                .click();
        PastebinPage pastebinPage = new PastebinPage(driver);
        pastebinPage.createNewPaste(code, syntaxHighlighting, pasteExpiration, pasteName);

        PasteAssertions pasteAssertions = new PasteAssertions(driver);
        pasteAssertions.assertTitle(pasteName);
        pasteAssertions.assertSyntaxHighlighting(syntaxHighlighting);
        pasteAssertions.assertCode(code);
        driver.quit();
    }
}
