package pl.nogacz.chess.application;

public class WinningOdds {

    public static void evaluatePoints(int calculation){
        calculation = (calculation + 100) / 2;
        if(calculation > 100)
            calculation = 100;
        if(calculation < 0)
            calculation = 0;
        setSlider(calculation);
    }

    public static void setSlider(int value) {
        Design.winChance.setValue(value);
        Design.winChance.setStyle("-fx-background-color: linear-gradient(to right, #000 " + value + "%, #fff " + (100 - value) + "%)!important;");
    }
}
