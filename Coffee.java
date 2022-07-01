/**
 * Lab 2
 * Created Coffee interface and added constructors
 * CS 160L-01
 * 06 03 2022
 * @author Yan Ho
 */


public interface Coffee {
    void addTopping (Coffee coffee);
    String printCoffee ();

    double Cost();

    void push(String printOrder);
}
