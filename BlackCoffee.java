/**
 * Lab 2
 * Created BlackCoffee and added constructors
 * CS 160L-01
 * 06 03 2022
 * @author Yan Ho
 */

public class BlackCoffee extends CoffeeDecorator {
    public BlackCoffee (Coffee coffee) {
        super (coffee);
    }

    @Override
    public void addTopping(Coffee coffee) {
        instructions();
    }

    public void instructions() {
        System.out.println("Pour coffee from pot into cup");
    }

    @Override
    public String printCoffee() {
        return this.coffee.printCoffee();
    }

    @Override
    public double Cost() {
        return this.coffee.Cost();
    }
}


/*
    @Override
    public double Cost() {
        if(coffee instanceof CoffeeDecorator) {
            return ((CoffeeDecorator)coffee).Cost() + 0.85;
        }

        return 0.85;
    }
*/
