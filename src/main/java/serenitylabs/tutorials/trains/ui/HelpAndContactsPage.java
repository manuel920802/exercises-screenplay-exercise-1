package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HelpAndContactsPage {

    public static class AboutOyster {
        public static Target CONTACT_US = Target.the("Help about the TFL App").located(By.linkText("Contact us about Oyster"));
    }
}
