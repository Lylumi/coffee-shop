/**
 * Lab 2
 * Created BasicCoffee and added constructors
 * CS 160L-01
 * 06 03 2022
 * @author Yan Ho
 */

public class BasicCoffee implements Coffee {

    @Override
    public String printCoffee () {
        return "A black coffee";
    }

    @Override
    public void addTopping (Coffee coffee) {
    }

    @Override
    public double Cost() {
        return 0.85;
    }
}
