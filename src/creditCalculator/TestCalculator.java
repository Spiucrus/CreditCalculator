package creditCalculator;

public class TestCalculator {
    public static void main(String[] args) {
        Calculate calculate = new Calculate(Input.setLoan(),Input.setYearsRate(),Input.setYearsTerm());
        calculate.start();
    }

}
