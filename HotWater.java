/**
 * Lab 2
 * Created HotWater and added constructors
 * CS 160L-01
 * 06 03 2022
 * @author Yan Ho
 */

public class HotWater extends CoffeeDecorator{
    public HotWater (Coffee coffee) {
        super(coffee);
    }
    @Override
    public void addTopping(Coffee coffee) {
    }

    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + " and hot water";
    }

    @Override
    public double Cost() {
        if (coffee instanceof CoffeeDecorator) {
            return ((CoffeeDecorator) coffee).Cost() + 0.0;
        }

        return 0.0;
    }
}
