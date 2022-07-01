/**
 * Lab 2
 * Created CoffeeDecorator and added constructors
 * CS 160L-01
 * 06 03 2022
 * @author Yan Ho
 */


public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public void addTopping(Coffee coffee) {
        this.coffee.addTopping(coffee);
    }

    public String printCoffee() {
        return this.coffee.printCoffee();
    }
    public abstract double Cost();
}


/*  @Override
    public String printCoffee () {
        return "";
    }

    @Override
    public void addTopping (Coffee coffee) {

    }
*/
