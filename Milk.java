/**
 * Lab 2
 * Created Milk and added constructors
 * CS 160L-01
 * 06 03 2022
 * @author Yan Ho
 */

public class Milk extends CoffeeDecorator {
    public Milk (Coffee coffee) {
        super (coffee);
    }

    @Override
    public void addTopping(Coffee coffee) {
    }

    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + " with milk";
    }

    @Override
    public double Cost() {
        if (coffee instanceof CoffeeDecorator) {
            return ((CoffeeDecorator) coffee).Cost() + 0.15;
        }

        return 0.15;
    }
}
