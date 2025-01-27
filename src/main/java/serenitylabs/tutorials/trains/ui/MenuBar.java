package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public enum MenuBar {
    STATUS_UPDATES (By.linkText("Status updates")),
    HELP_AND_CONTACTS(By.linkText("Help & contacts")),
    MAPS(By.linkText("Maps")),
    FARES(By.linkText("Fares")),
    PLAN_A_JOURNEY(By.linkText("Plan a journey")),
    MORE_MENU(By.id("more-tab"));

    private final By byLocator;

    MenuBar(By by) {
       this.byLocator = by;
    }

    public Target menuOption(){
        return Target.the(this.name()).located(byLocator);
    }
}
