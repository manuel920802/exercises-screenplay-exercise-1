package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.ui.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static serenitylabs.tutorials.trains.ui.ContactForm.*;
import static serenitylabs.tutorials.trains.ui.MenuBar.*;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed
    WebDriver browser;

    Actor carrie = Actor.named("Carrie");

    @Before
    public void setTheStage(){
        carrie.can(BrowseTheWeb.with(browser));
    }
    @Test
    public void planning_a_simple_trip(){

        carrie.attemptsTo(Open.browserOn().the(TFLHomePage.class));

        carrie.should(seeThat(TheWebPage.title(), containsString("Transport for London")));
    }

    @Test
    public void the_status_updates_page_title_should_be_visible(){

        carrie.attemptsTo(Open.browserOn().the(StatusUpdatesPage.class));

        carrie.should(seeThat(TheWebPage.title(), containsString("Status Updates")));
    }

    @Test
    public void should_be_able_to_search_for_station_details(){

        carrie.attemptsTo(Open.browserOn().the(TFLHomePage.class),
                Enter.theValue("Waterloo").into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
        );

        carrie.should(seeThat(TheTarget.textOf(SearchResultsPage.SEARCH_RESULTS_HEADING), equalTo("Search: Waterloo")));
    }

    @Test
    public void should_list_all_relevant_station_information(){

        carrie.attemptsTo(Open.browserOn().the(TFLHomePage.class),
                Enter.theValue("Jubilee").into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
                );

        carrie.should(seeThat(TheTarget.textOf(SearchResultsPage.FIRST_ARTICLE_HEADING), equalTo("Jubilee Greenway - Transport for London")));
    }

    @Test
    public void should_see_status_updates(){
    carrie.attemptsTo(
            Open.browserOn().the(TFLHomePage.class),
            Click.on(STATUS_UPDATES.menuOption())
    );

    carrie.should(seeThat(TheTarget.textValuesOf(StatusUpdatesPage.SERVICE_LINES), hasItems("Bakerloo", "Central", "Circle")));
    }

    @Test
    public void should_be_able_to_contact_tfl(){
        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class)
        );

        carrie.attemptsTo(
                Click.on(HELP_AND_CONTACTS.menuOption()),
                Click.on(HelpAndContacts.AboutOyster.CONTACT_US)
        );

        carrie.attemptsTo(
                SelectFromOptions.byVisibleText("Mrs").from(TITLE.formField()),
                Enter.theValue("Sarah-Jane").into(FIRST_NAME.formField()),
                Enter.theValue("Smith").into(LAST_NAME.formField())
        );

        carrie.should(seeThat(TheTarget.selectedValueOf(TITLE.formField()), equalTo("Mrs")),
                seeThat(TheTarget.valueOf(FIRST_NAME.formField()), equalTo("Sarah-Jane")),
                seeThat(TheTarget.valueOf(LAST_NAME.formField()),equalTo("Smith"))
                );
    }
}
