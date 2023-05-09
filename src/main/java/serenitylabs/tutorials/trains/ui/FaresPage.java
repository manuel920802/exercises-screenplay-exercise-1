package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FaresPage {
        public static final Target TEXT_LINK = Target.the("text link {0}").locatedBy("//div[@class='text-link']/h3[contains(.,'{0}')]");
        public static final Target CONTACTLESS_AND_MOBILE_PAY = FaresPage.TEXT_LINK.of("Contactless pay as you go");

}
