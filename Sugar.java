/**
 * Lab 2
 * Created Sugar and added constructors
 * CS 160L-01
 * 06 03 2022
 * @author Yan Ho
 */

public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void addTopping(Coffee coffee) {
    }

    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + " and sugar";
    }

    @Override
    public double Cost() {
        if (coffee instanceof CoffeeDecorator) {
            return ((CoffeeDecorator) coffee).Cost() + 0.05;
        }

        return 0.05;
    }
}
