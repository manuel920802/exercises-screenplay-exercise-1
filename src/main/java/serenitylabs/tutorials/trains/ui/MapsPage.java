package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
@DefaultUrl("https://tfl.gov.uk/maps")
public class MapsPage extends PageObject {

    //Map types
    public static final Target TEXT_LINK = Target.the("text link {0}").locatedBy("//div[@class='text-link']/h2[contains(.,'{0}')]");
    public static final Target TUBE_AND_RAIL_MAPS = MapsPage.TEXT_LINK.of("Tube and Rail maps");
    public static final Target BUS_MAPS = MapsPage.TEXT_LINK.of("Bus maps");
    public static final Target CYCLE_MAP = MapsPage.TEXT_LINK.of("Cycle map");
    public static final Target RIVERS_MAP = MapsPage.TEXT_LINK.of("Rivers maps");
    public static final Target TFL_GO_APP = MapsPage.TEXT_LINK.of("TfL Go");

    //Services types
    public static final Target NEARBY = Target.the("Near your current location services").located(By.linkText("nearby"));
    public static final Target TUBE = Target.the("Tube service").located(By.linkText("tube"));
    public static final Target OVERGROUND = Target.the("Overground service").located(By.linkText("overground"));

    public static final Target DOWNLOAD_THE_APP = Target.the("Download tfl go app").located(By.linkText("Download the app")) ;
    public static final Target GOOGLE_PLAY_LINK = Target.the("Android link").located(By.linkText("Android"));
}
