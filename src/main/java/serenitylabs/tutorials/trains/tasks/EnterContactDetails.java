package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static serenitylabs.tutorials.trains.ui.ContactForm.*;

public class EnterContactDetails implements Performable {

    private final String title;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String confirmEmail;
    private final String phoneNumber;
    private final String bestTimeToCall;

    public EnterContactDetails(String title, String firstName, String lastName, String emailAddress, String confirmEmail, String phoneNumber, String bestTimeToCall) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.confirmEmail = confirmEmail;
        this.phoneNumber = phoneNumber;
        this.bestTimeToCall = bestTimeToCall;
    }

    public static Performable forCustomer(String title, String firstName, String lastName, String emailAddress, String confirmEmail, String phoneNumber, String bestTimeToCall) {
        return instrumented(EnterContactDetails.class, title, firstName, lastName, emailAddress, confirmEmail, phoneNumber, bestTimeToCall);
    }

    @Override
    @Step("{0} enters contact details for #title #firstName #lastName #emailAddress #confirmEmail #phoneNumber #bestTimeToCall")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(title).from(TITLE.formField()),
                Enter.theValue(firstName).into(FIRST_NAME.formField()),
                Enter.theValue(lastName).into(LAST_NAME.formField()),
                Enter.theValue(emailAddress).into(EMAIL_ADDRESS.formField()),
                Enter.theValue(confirmEmail).into(CONFIRM_EMAIL.formField()),
                Enter.theValue(phoneNumber).into(PHONE_NUMBER.formField()),
                SelectFromOptions.byValue(bestTimeToCall).from(BEST_TIME_TO_CALL.formField())
        );
    }
}
