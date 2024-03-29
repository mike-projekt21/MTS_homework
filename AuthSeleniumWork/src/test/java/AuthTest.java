import org.junit.Assert;
import org.junit.Test;
import pages.AuthPage;
import pages.MainPage;

public class AuthTest extends BaseTest {

    //region Context
    private AuthPage authPage = new AuthPage(driver);
    private MainPage mainPage = new MainPage(driver);
    //endregion

    //region Tests
    @Test
    public void popUpMessageTest() {
        mainPage.startAuth();
        String popUpClass = authPage.auth(config.login(), config.password())
                .getAuthPopUpClass();

        Assert.assertTrue(popUpClass.contains("popup_good"));
    }

    @Test
    public void mainPageProfileTest() {
        mainPage.startAuth();
        boolean isFoundProfileMenu = authPage.auth(config.login(), config.password())
                .finishAuth()
                .waitHeaderProfile();

        Assert.assertTrue(isFoundProfileMenu);
    }
    //endregion
}
