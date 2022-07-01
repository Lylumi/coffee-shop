/**
 * Lab 2
 * Created Main and added constructors
 * CS 160L-01
 * 06 03 2022
 *
 * @author Yan Ho
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    /**
     * In this method, we are creating inputting a coffee order and asking
     * The customer if they would like toppings (if so, what kind), and if they would
     * Like to create another order of coffee.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        ArrayList<Coffee> items = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<String> temp2 = new ArrayList<>();

        Scanner userOrders = new Scanner(System.in);
        int[] inventory = new int[6];

        System.out.println("Coffee order created. Select toppings for the first coffee: ");

        String line = "yes";

        do {
            temp2 = createOrder(inventory);
            items.add((Coffee) temp2);
            price.add(Double.valueOf(temp2.get(1)));
            if (inventory[0] == 0) {
                System.out.println("Order completed. No more coffees.");
                break;
            }
            System.out.println("Do you want to add another coffee to this order? - yes or no");
        }
        while (!(line = userOrders.nextLine()).equals("no)"));


        Stack<String> printOrder = new Stack<String>();
        printOrder.push(printOrder(items, price));

        Scanner cafeApplication = new Scanner(System.in);
        System.out.println("Cafe Application Running... ");
        int input = 0;
        while (input != 1) {
            switch (cafeApplication.nextLine()) {
                case "1":
                    inventoryReader();
                    break;
                case "2":
                    Coffee basicCoffee = new BasicCoffee();
                    basicCoffee.push(printOrder(items, price));
                    break;
                case "3":
                    inventoryWriter();
                    break;
                case "4":
                    logWriter();
                    Coffee myWriter = null;
                    String file = null;
                    myWriter.push(file);
                    break;
                case "5":
                    Coffee inventoryWriter = null;
                    inventoryWriter.push();
                    myWriter.push();
                    input = 1;
                    break;
                default:
                    System.out.println("Invalid Selection. Please Try Again");
            }
        }
    }

    /**
     * Here, we are creating a method inventoryReader to read the inventory. inventoryReader
     * will read the inventory txt and determine if we have the ingredients to create the
     * particular order the customer wants.
     *
     * @return inventory.txt to see if we have enough ingredients to create the order.
     */
    public static int[] inventoryReader() {
        int[] array = new int[6];

        try {
            File file = new File("C:\\Users\\Yan\\Desktop\\Inventory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            int counter = 0;

            while ((str = reader.readLine()) != null) {
                System.out.println(str);
                array[counter++] = Integer.parseInt(str.substring(str.length() - 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Here, we have the method inventoryWriter, which updates the inventory.txt. After each order
     * is created, inventoryWriter will update the ingredients list to see if we have sufficient
     * ingredients to create a new order.
     *
     * @return new values for inventory.txt since it will be updating that text file.
     */
    public static int[] inventoryWriter() {
        int[] array = new int[6];
        array.equals(inventoryReader());

        try {
            File file = new File("C:\\Users\\Yan\\Desktop\\Inventory.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully updated the inventory.");
        return array;
    }

    /**
     * The purpose of logWriter is to log the information down, basically a receipt. It will keep
     * track of orders as well as the time and date. It will also provide an order number/tracker
     * for both the customer and our company.
     */
    public static void logWriter() {
        try {
            FileWriter myWriter = new FileWriter("LogFile.txt", true);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            myWriter.write("\n\nWriting orders from stack " + formatter.format(date));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                FileWriter myWriter = null;
                if (myWriter != null) {
                    System.out.println("Successfully updated the log file");
                }
                if (myWriter == null) {
                    System.out.println("Nothing to log. Stack is empty");
                    myWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * The purpose of this method is to create a sizing option for the customers. The options the
     * customers are given are small, medium, and large.
     * @param small
     * @param medium
     * @param large
     * @return the total amount of the order with the price of the size option the customer chose.
     */
    public double size(double small, double medium, double large) {
        String size;
        double sum = 0;
        double total = 0;
        double small = 0.30;
        double medium = 0.50;
        double large = 0.70;

        Coffee basicCoffee = new BasicCoffee();

        if (size.equals("s")) {
            sum = coffee.Cost() + small;
        } else if (size.equals("m")) {
            sum = coffee.Cost() + medium;
        } else if (size.equals("l")) {
            sum = coffe.Cost() + large;
        }
        total = coffee.Cost();
        return total;
    }

    /**
     * The purpose of this method is to print out the order given, using String builder. The code
     * will print out the cost of the item and the item name.
     * @param items
     * @param price
     * @return total cost of the order.
     */
    public static String printOrder(ArrayList<Coffee> items, ArrayList<Double> price) {
        StringBuilder sb = new StringBuilder();
        double sum = 0;

        sb.append("RECEIPT\n").append("\n");

        Iterator<Coffee> orderItems = items.iterator();

        int counter = 1;

        while (orderItems.hasNext()) {

            CoffeeDecorator coffee = (CoffeeDecorator) orderItems.next();

            sb.append("Item ")
                    .append(counter++)
                    .append(": ")
                    .append(coffee.printCoffee())
                    .append(" | Cost: ")
                    .append(String.format("%2.2f", coffee.Cost()))
                    .append("\n")
                    .append("\n");

            sum += coffee.Cost();
        }

        sb.append(String.format("TOTAL COST OF ORDER: %2.2f", sum));

        return sb.toString();
    }

    /**
     * The purpose of this method is to create the order. This is the first step in the program.
     * Here, we ask what the customer wants to order. We then take down their order and ask if
     * they would like to order anything else or if they are done ordering.
     * @param inventory
     * @return coffee order.
     */
    public static ArrayList<String> createOrder(int[] inventory) {
        if (inventory[0] == 0) {
            System.out.println("Out of Coffee. Visit us later.");
            System.exit(0);
        }

        Scanner userFeedback = new Scanner(System.in);
        ArrayList<String> coffeeOrder = new ArrayList<String>();

        Coffee basicCoffee = new BasicCoffee();
        int input = 0;

        while (input != 1) {
            System.out.println("Enter the following values to add toppings:" +
                    "1. milk, 2. hot water, 3. espresso, 4. sugar, 5. whipped cream, " +
                    "e - to complete order");

            switch (userFeedback.nextLine()) {
                case "1":
                    if (inventory[1] != 0) {
                        basicCoffee = new Milk(basicCoffee);
                        inventory[1] = inventory[1] - 1;
                    } else {
                        System.out.println("Out of milk. Try a different topping.");
                    }
                    break;

                case "2":
                    if (inventory[2] != 0) {
                        basicCoffee = new HotWater(basicCoffee);
                        inventory[2] = inventory[2] - 1;
                    } else {
                        System.out.println("Out of hot water. Try a different topping.");
                    }
                    break;

                case "3":
                    if (inventory[3] != 0) {
                        basicCoffee = new Espresso(basicCoffee);
                        inventory[3] = inventory[3] - 1;
                    } else {
                        System.out.println("Out of espresso. Try a different topping.");
                    }
                    break;

                case "4":
                    if (inventory[4] != 0) {
                        basicCoffee = new Sugar(basicCoffee);
                        inventory[4] = inventory[4] - 1;
                    } else {
                        System.out.println("Out of sugar. Try a different topping.");
                    }
                    break;

                case "5":
                    if (inventory[5] != 0) {
                        basicCoffee = new WhippedCream(basicCoffee);
                        inventory[5] = inventory[5] - 1;
                    } else {
                        System.out.println("Out of whipped cream. Try a different topping.");
                    }
                    break;

                case "e":
                    input = 1;
                    break;

                default:
                    System.out.println("Invalid Input");
            }
        }

        coffeeOrder.add(basicCoffee.printCoffee() + " " + basicCoffee.Cost());
        return coffeeOrder;
    }
}

