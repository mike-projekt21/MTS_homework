import org.junit.Assert;
import org.junit.Test;
import pages.AuthPage;
import pages.BasePage;
import pages.MainPage;

public class AuthTest extends BaseTest {

    //region Tests
    @Test
    public void popUpMessageTest() {
        MainPage mainPage = BasePage.createPage(MainPage.class, driver);
        AuthPage authPage = BasePage.createPage(AuthPage.class, driver);

        mainPage.startAuth();
        String popUpClass = authPage.auth(config.login(), config.password())
                .getAuthPopUpClass();

        Assert.assertTrue(popUpClass.contains("popup_good"));
    }

    @Test
    public void mainPageProfileTest() {
        AuthPage authPage = BasePage.createPage(AuthPage.class, driver);
        MainPage mainPage = BasePage.createPage(MainPage.class, driver);

        mainPage.startAuth();
        boolean isFoundProfileMenu = authPage.auth(config.login(), config.password())
                .finishAuth()
                .waitHeaderProfile();

        Assert.assertTrue(isFoundProfileMenu);
    }
    //endregion
}
