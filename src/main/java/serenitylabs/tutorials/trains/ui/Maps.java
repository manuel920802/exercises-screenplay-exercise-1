package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Maps {

    public static class MapType{
        public static final Target TUBES_AND_RAIL_MAPS = Target.the("Tubes and rail maps news teaser").located(By.linkText("Tube and Rail maps")) ;
    }
}
