package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FaresPage {
    public static class contactLessPay{
        public static final Target CONTACTLESS_AND_MOBILE_PAY = Target.the("Contactless and mobile pay").located(By.linkText("Contactless pay as you go"));
    }
}
