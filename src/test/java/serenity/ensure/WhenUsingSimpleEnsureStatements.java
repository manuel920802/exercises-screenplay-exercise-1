package serenity.ensure;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.NamedExpectation;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RunWith(SerenityRunner.class)
public class WhenUsingSimpleEnsureStatements {
    LocalDate januaryFirst2015 = LocalDate.of(2015, Month.JANUARY, 1);
    LocalDate januaryFirst2018 = LocalDate.of(2018, Month.JANUARY, 1);

    List<String> colors = Arrays.asList("red", "green", "blue");

    public static final NamedExpectation<String> IS_A_PRIMARY_COLOR = new NamedExpectation<>(
            "a primary color",
            color -> color.equals("red") || color.equals("blue") || color.equals("yellow")
    );

    Actor penny = Actor.named("Penny");
    Pet fido = new Pet("Fido the dog", januaryFirst2015);
    @Test
    public void we_should_be_able_to_make_assertions_about_strings(){
        penny.attemptsTo(
                Ensure.that(fido.getName()).isEqualTo("Fido the dog"),
                Ensure.that(fido.getName()).startsWith("Fido"),
                Ensure.that(fido.getName()).endsWith("the dog")
        );
    }

    @Test
    public void we_should_be_able_to_make_assertions_about_integers(){
        penny.attemptsTo(
                Ensure.that(fido.getAge()).isGreaterThan(1)
        );
    }

    @Test
    public void we_can_compare_dates(){
        penny.attemptsTo(
                Ensure.that(fido.getDateOfBirth()).isBefore(januaryFirst2018)
        );
    }

    @Test
    public void matchingColors(){
        penny.attemptsTo(
                Ensure.that(colors).contains("red", "blue"),
                Ensure.that(colors).hasSize(3),
                Ensure.that(colors).isNotEmpty(),
                Ensure.that(colors).doesNotHaveDuplicates(),
                Ensure.that(colors).containsAnyOf("red","pink"),
                Ensure.that(colors).doesNotContain("pink")
        );
    }

    @Test
    public void containsAPrimaryColor(){
        penny.attemptsTo(
                Ensure.that(colors).anyMatch(IS_A_PRIMARY_COLOR)
        );
    }
}
