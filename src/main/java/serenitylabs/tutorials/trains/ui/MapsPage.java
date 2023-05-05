package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MapsPage extends PageObject {
    public static final Target MAP_HEADING = Target.the("Maps headline").located(By.className("headline-container"));
}
