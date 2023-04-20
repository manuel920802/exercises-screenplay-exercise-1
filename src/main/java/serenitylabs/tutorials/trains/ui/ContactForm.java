package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public enum ContactForm{
    TITLE(By.name("PersonalDetails.Title")),
    FIRST_NAME(By.name("PersonalDetails.FirstName")),
    LAST_NAME(By.name("PersonalDetails.LastName")),
    EMAIL_ADDRESS(By.name("PersonalDetails.EmailAddress")),
    CONFIRM_EMAIL(By.name("PersonalDetails.ConfirmEmailAddress")),
    PHONE_NUMBER(By.name("PersonalDetails.PhoneNumber")),
    BEST_TIME_TO_CALL(By.name("Feedback.BestTimeToContact"));
    private final By byLocator;

    ContactForm(By by) {
        this.byLocator = by;
    }
    public Target formField(){
        return Target.the(this.name()).located(byLocator);
    }
}
