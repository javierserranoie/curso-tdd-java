import java.util.List;

public class DrinkMachine {

    DrinkMaker drinkMaker;

    String command;
    boolean hasSugar;

    public DrinkMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public DrinkMachine start() {
        command = "";
        hasSugar = false;
        return this;
    }

    public DrinkMachine prepareBeverage(String beverage) {
        if (List.of("T","H","C").contains(beverage)){
            command += beverage;
        }
        return this;
    }

    public DrinkMachine addSugar(int sugarDrops) {
        hasSugar = true;
        if (sugarDrops<3) {
            command += ":" + sugarDrops + ":";
        }
        else {
            command = "::";
        }
        return this;
    }

    public void order() {
        command = hasSugar ? command : command + "::";
        if (hasBeverage()) {
            drinkMaker.execute(command);
        }
    }

    private boolean hasBeverage() {
        return !command.startsWith(":");
    }
}
