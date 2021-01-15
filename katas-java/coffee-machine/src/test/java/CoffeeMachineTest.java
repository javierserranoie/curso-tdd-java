import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CoffeeMachineTest {

//    The drink maker should receive the correct instructions for my coffee / tea / chocolate order
//    I want to be able to send instructions to the drink maker to add one or two sugars
//    When my order contains sugar the drink maker should add a stick (touillette) with it

//    "T:1:0" (Drink maker makes 1 tea with 1 sugar and a stick)
//    "H::" (Drink maker makes 1 chocolate with no sugar and therefore no stick)
//    "C:2:0" (Drink maker makes 1 coffee with 2 sugars and a stick)
//    "M:message-content" (Drink maker forwards any message received onto the coffee machine interface for the customer to see)

    @Test
    public void given_a_beverage_when_prepare_beverage_then_order_drink_maker_to_prepare_beverage() {
        // GIVEN
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        DrinkMachine drinkMachine = new DrinkMachine(drinkMaker);

        // WHEN
        drinkMachine.start()
                .prepareBeverage("C")
                .order();

        // THEN
        verify(drinkMaker).execute("C::");
    }

    @Test
    public void given_a_beverage_with_sugar_when_prepare_beverage_then_order_drink_maker_to_prepare_beverage_and_add_sugar() {
        // GIVEN
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        DrinkMachine drinkMachine = new DrinkMachine(drinkMaker);

        // WHEN
        drinkMachine.start()
                .prepareBeverage("C")
                .addSugar(1)
                .order();

        // THEN
        verify(drinkMaker).execute("C:1:");
    }

    @Test
    public void given_no_beverage_with_sugar_when_prepare_the_order_then_no_order() {
        // GIVEN
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        DrinkMachine drinkMachine = new DrinkMachine(drinkMaker);

        // WHEN
        drinkMachine.start()
                .addSugar(1)
                .order();

        // THEN
        verify(drinkMaker, times(0)).execute(":1:");
    }

    @Test
    public void given_a_not_valid_beverage_when_prepare_the_order_then_no_order() {
        // GIVEN
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        DrinkMachine drinkMachine = new DrinkMachine(drinkMaker);

        // WHEN
        drinkMachine.start()
                .prepareBeverage("X")
                .order();

        // THEN
        verify(drinkMaker, times(0)).execute("X::");
    }

    @Test
    public void given_a_beverage_with_more_than_2_sugars_when_prepare_the_order_then_no_order() {
        // GIVEN
        DrinkMaker drinkMaker = mock(DrinkMaker.class);
        DrinkMachine drinkMachine = new DrinkMachine(drinkMaker);

        // WHEN
        drinkMachine.start()
                .prepareBeverage("C")
                .addSugar(4)
                .order();

        // THEN
        verify(drinkMaker, times(0)).execute("C:4:");
    }
}
