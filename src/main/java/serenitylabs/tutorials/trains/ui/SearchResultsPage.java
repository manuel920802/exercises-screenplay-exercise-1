package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchResultsPage extends PageObject {
    public static final Target SEARCH_RESULTS_HEADING = Target.the("Search headline").located(By.className("hero-headline"));

    public static final Target FIRST_ARTICLE_HEADING = Target.the("first article heading").locatedBy(".search-results h3");
}
