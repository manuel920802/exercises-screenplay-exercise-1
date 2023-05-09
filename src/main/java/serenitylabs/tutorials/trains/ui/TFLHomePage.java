package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://tfl.gov.uk/")
public class TFLHomePage extends PageObject {
    public static final Target SEARCH = Target.the("Search field").located(By.id("q"));

    public static final Target FROM_INPUT_FIELD = Target.the("From input field").located(By.className("jpFrom"));
    public static final Target TO_INPUT_FIELD = Target.the("To input field").located(By.className("jpTo"));
    public static final Target CHANGE_DEPARTURE_TIME = Target.the("Change departure time link").located(By.className("change-departure-time"));
    public static final Target DATE_PICKER = Target.the("Date picker dropdown").located(By.id("Date"));
    public static final Target TIME_PICKER = Target.the("Time picker dropdown").located(By.id("Time"));
}
