/**
 * Lab 2
 * Created Espresso and added constructors
 * CS 160L-01
 * 06 03 2022
 * @author Yan Ho
 */

public class Espresso extends CoffeeDecorator{
    public Espresso (Coffee coffee) {
        super(coffee);
    }
    @Override
    public void addTopping(Coffee coffee) {
    }

    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + " and espresso";
    }
    @Override
    public double Cost() {
        if (coffee instanceof CoffeeDecorator) {
            return ((CoffeeDecorator) coffee).Cost() + 0.35;
        }

        return 0.35;
    }
}
