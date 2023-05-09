package serenitylabs.tutorials.trains;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.ui.Button;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.questions.SearchResults;
import serenitylabs.tutorials.trains.questions.TheContactDetails;
import serenitylabs.tutorials.trains.questions.TheServiceLines;
import serenitylabs.tutorials.trains.tasks.EnterContactDetails;
import serenitylabs.tutorials.trains.tasks.Search;
import serenitylabs.tutorials.trains.tasks.SelectMenu;
import serenitylabs.tutorials.trains.ui.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import static serenitylabs.tutorials.trains.ui.MenuBar.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenPlanningATrip {

    @Managed
    WebDriver browser;

    Actor carrie = Actor.named("Carrie");

    @Before
    public void setTheStage(){
        carrie.can(BrowseTheWeb.with(browser));

        carrie.attemptsTo(
                Open.browserOn().the(TFLHomePage.class),
                Click.on(Button.withText("Accept all cookies"))
        );
    }
    @Test
    public void planning_a_simple_trip(){

        carrie.should(seeThat(TheWebPage.title(), containsString("Transport for London")));
    }

    @Test
    public void the_status_updates_page_title_should_be_visible(){

        carrie.should(seeThat(TheWebPage.title(), containsString("Status Updates")));
    }

    @Test
    public void should_be_able_to_search_for_station_details(){

        carrie.attemptsTo(
                Search.forStation("Waterloo")
        );

        carrie.should(seeThat(SearchResults.heading(), equalTo("Search: Waterloo")));
    }

    @Test
    public void should_list_all_relevant_station_information(){

        carrie.attemptsTo(
                Enter.theValue("Jubilee").into(TFLHomePage.SEARCH).thenHit(Keys.ENTER)
                );

        carrie.should(seeThat(TheTarget.textOf(SearchResultsPage.FIRST_ARTICLE_HEADING), equalTo("Jubilee Greenway - Transport for London")));
    }

    @Test
    public void should_be_able_to_see_status_updates(){
    carrie.attemptsTo(SelectMenu.option(STATUS_UPDATES));

    carrie.should(seeThat(TheServiceLines.displayed(), hasItems("Bakerloo", "Central", "Circle")));
    }

    @Test
    public void should_be_able_to_contact_tfl(){

        carrie.attemptsTo(
                SelectMenu.option(HELP_AND_CONTACTS),
                Click.on(HelpAndContactsPage.AboutOyster.CONTACT_US)
        );

        carrie.attemptsTo(
                EnterContactDetails.forCustomer("Mrs",
                        "Sarah-Jane",
                        "Smith",
                        "qatest@email.com",
                        "qatest@email.com",
                        "123456789",
                        "8am - 12pm")
        );

        carrie.should(
                seeThat(TheContactDetails.title(), equalTo("Mrs")),
                seeThat(TheContactDetails.firstName(), equalTo("Sarah-Jane")),
                seeThat(TheContactDetails.lastName(),equalTo("Smith")),
                seeThat(TheContactDetails.emailAddress(),equalTo("qatest@email.com")),
                seeThat(TheContactDetails.confirmEmail(),equalTo("qatest@email.com")),
                seeThat(TheContactDetails.phoneNumber(),equalTo("123456789")),
                seeThat(TheContactDetails.bestTimeToCall(),equalTo("8am - 12pm"))
        );
    }

    @Test
    public void should_be_able_to_see_maps(){
        carrie.attemptsTo(SelectMenu.option(MAPS));

        carrie.should(seeThat(TheWebPage.title(), containsString("Maps")));
    }

    @Test
    public void should_be_able_to_look_for_tube_services_on_selected_map(){
        carrie.attemptsTo(SelectMenu.option(MAPS),
                Click.on(MapsPage.TUBE_AND_RAIL_MAPS)
        );
        carrie.should(seeThat(TheWebPage.title(), containsString("Tube and Rail")));

        carrie.attemptsTo(SelectMenu.option(MAPS),
                Click.on(MapsPage.TUBE_AND_RAIL_MAPS),
                Click.on(MapsPage.OVERGROUND)
        );
        carrie.should(seeThat(TheWebPage.title(), containsString("Overground")));
    }

    @Test
    public void should_be_able_to_download_tfl_app(){
        carrie.attemptsTo(SelectMenu.option(MAPS),
                Click.on(MapsPage.TFL_GO_APP),
                Click.on(MapsPage.DOWNLOAD_THE_APP),
                Click.on(MapsPage.GOOGLE_PLAY_LINK)
        );

        carrie.should(seeThat(TheWebPage.title(), containsString("TfL Go: Live Tube, Bus & Rail")));
    }

    @Test
    public void should_be_able_to_see_fares(){
        carrie.attemptsTo(SelectMenu.option(FARES));

        carrie.should(seeThat(TheWebPage.title(), containsString("Fares")));
    }

    @Test
    public void should_be_able_to_see_contactless_pay_info(){
        carrie.attemptsTo(SelectMenu.option(FARES),
                Click.on(FaresPage.CONTACTLESS_AND_MOBILE_PAY)
        );
    }

    @Test
    public void should_be_able_to_plan_a_journey(){
        carrie.attemptsTo(SelectMenu.option(PLAN_A_JOURNEY),
                Enter.theValue("Waterloo").into(TFLHomePage.FROM_INPUT_FIELD),
                Enter.theValue("Jubilee").into(TFLHomePage.TO_INPUT_FIELD),
                Click.on(TFLHomePage.CHANGE_DEPARTURE_TIME),
                SelectFromOptions.byVisibleText("Tomorrow").from(TFLHomePage.DATE_PICKER),
                SelectFromOptions.byVisibleText("23:00").from(TFLHomePage.TIME_PICKER),
                Click.on(Button.withText("Plan my journey"))
        );

        carrie.should(seeThat(TheWebPage.title(),containsString("Journey Results")));
    }

    @Test
    public void should_be_able_to_access_more_links_from_menu(){
        carrie.attemptsTo(SelectMenu.option(MORE_MENU));
    }
}
