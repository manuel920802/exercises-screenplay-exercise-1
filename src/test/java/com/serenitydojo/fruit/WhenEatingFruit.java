package com.serenitydojo.fruit;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.markers.CanBeSilent;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class WhenEatingFruit {
    Actor eddie = Actor.named("Eddie");
    @Test
    public void eating_apples(){
        eddie.wasAbleTo(Peel.anApple().inPlainSight());
        eddie.attemptsTo(Eat.anApple(), Eat.aLargePear(), Eat.aSmallPear());
    }

    public static class Peel{
        public static PeelsAnApple anApple() {
            return new PeelsAnApple();
        }
    }

    public static class Eat {
        public static Performable anApple() {
            return new EatsAnApple();
        }
        public static Performable aLargePear() {
            return new EatsAPear("large");
        }
        public static Performable aSmallPear() {
            return new EatsAPear("small");
        }
    }

        public static class EatsAnApple implements Performable {
            @Override
            public <T extends Actor> void performAs(T t) {}
        }
        public static class PeelsAnApple implements Performable, CanBeSilent {
        private boolean isSilent = true;

        @Override
        public <T extends Actor> void performAs(T t) {}

            @Override
            public boolean isSilent() {
                return isSilent;
            }
            public PeelsAnApple inPlainSight() {
            this.isSilent = false;
            return this;
            }
        }

        public static class EatsAPear implements Performable{
            public EatsAPear(){}
            private String size ="";

            public EatsAPear(String size) {
                this.size = size;
            }
            @Override
            @Step("{0} eats a #size pear")
            public <T extends Actor> void performAs(T t) {}
        }
    }