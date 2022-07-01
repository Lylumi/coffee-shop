/**
 * Lab 2
 * Created WhippedCream and added constructors
 * CS 160L-01
 * 06 03 2022
 * @author Yan Ho
 */

public class WhippedCream extends CoffeeDecorator {
    public WhippedCream (Coffee coffee) {
        super(coffee);
    }
    @Override
    public void addTopping(Coffee coffee) {
    }

    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + " and whipped cream";
    }

    @Override
    public double Cost() {
        if (coffee instanceof CoffeeDecorator) {
            return ((CoffeeDecorator) coffee).Cost() + 0.10;
        }

        return 0.10;
    }
}
