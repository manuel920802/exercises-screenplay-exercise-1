package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://tfl.gov.uk/tube-dlr-overground/status/")
public class StatusUpdatesPage extends PageObject {
    public static final Target SERVICE_LINES = Target.the("Service lines").locatedBy(".service-name span");
}
