import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class AuthTest extends BaseTest{
    @Test
    public void popUpMessageTest() {
        MainPage mainPage = new MainPage();
        String popUpClass = mainPage
                .startAuth()
                .auth()
                .getAuthPopUpClass();
        Assert.assertTrue(popUpClass.contains("popup_good"));
    }
    @Test
    public void mainPageProfileTest() {
        MainPage mainPage = new MainPage();
        boolean isFoundProfileMenu = mainPage
                .startAuth()
                .auth()
                .finishAuth()
                .findProfileMenu();
        Assert.assertTrue(isFoundProfileMenu);
    }
}
