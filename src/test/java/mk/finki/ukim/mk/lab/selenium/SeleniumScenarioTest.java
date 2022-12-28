package mk.finki.ukim.mk.lab.selenium;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enumType.Role;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumScenarioTest {
    @Autowired
    UserService userService;
    @Autowired
    BalloonService balloonService;

    @Autowired
    ManufacturerService manufacturerService;

    private static Balloon b1;
    private static Balloon b2;
    private static Manufacturer m1;
    private static Manufacturer m2;
    private HtmlUnitDriver driver = new HtmlUnitDriver();

    private static User regularUser;
    private static User adminUser;
    private static String user = "user";
    private static String admin = "admin";

    private static boolean dataInitialized = false;

    @BeforeEach
    private void setup() {
        this.driver = new HtmlUnitDriver(true);
        initData();
    }
    private void initData() {
        if (!dataInitialized) {
            regularUser = userService.register(user, user, user, user, user, Role.ROLE_USER);
            adminUser = userService.register(admin, admin, admin, admin, admin,Role.ROLE_ADMIN);

            System.out.println(userService.register(admin, admin, admin, admin, admin, Role.ROLE_ADMIN));
            dataInitialized = true;
        }
    }


    @AfterEach
    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    @Test
    public void testScenario() throws Exception {
        BalloonsPage balloonsPage = BalloonsPage.to(this.driver);
        balloonsPage.assertElemts(0, 0, 0, 0);
        LoginPage loginPage = LoginPage.openLogin(this.driver);
//
//        balloonsPage = LoginPage.doLogin(this.driver, loginPage, adminUser.getUsername(), admin);
//        balloonsPage.assertElemts(0, 0, 0, 1);


    }

}
