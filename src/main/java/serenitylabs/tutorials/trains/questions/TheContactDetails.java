package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

import static serenitylabs.tutorials.trains.ui.ContactForm.*;

public class TheContactDetails {
    public static Question<String> title(){
        return TheTarget.valueOf(TITLE.formField());
    }
    public static Question<String> firstName() {
        return TheTarget.valueOf(FIRST_NAME.formField());
    }
    public static Question<String> lastName() {
        return TheTarget.valueOf(LAST_NAME.formField());
    }
    public static Question<String> emailAddress() {
        return TheTarget.valueOf(EMAIL_ADDRESS.formField());
    }
    public static Question<String> confirmEmail() {
        return TheTarget.valueOf(CONFIRM_EMAIL.formField());
    }
    public static Question<String> phoneNumber() {
        return TheTarget.valueOf(PHONE_NUMBER.formField());
    }
    public static Question<String> bestTimeToCall() {
        return TheTarget.valueOf(BEST_TIME_TO_CALL.formField());
    }


}
