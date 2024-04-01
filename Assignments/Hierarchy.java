package Assignments;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Represents a basic food item
class food {
    String name;

    // Constructor to initialize the food item's name
    public food(String name) {
        this.name = name;
    }

    // Getter method to retrieve the food item's name
    public String getName() {
        return name;
    }
}

// Represents a category of food items, inheriting from the Food class
class category extends food {
    private List<food> elements; // List to store food items in the category

    // Constructor to initialize the category with a name and an empty list of food items
    public category(String name) {
        super(name); // Calling superclass constructor to set the category's name
        this.elements = new ArrayList<>();
    }

    // Method to add a food item to the category
    public void addElement(food element) {
        elements.add(element);
    }

    // Method to retrieve the list of food items in the category
    public List<food> getElements() {
        return elements;
    }
}

public class Hierarchy {

    // Prints the hierarchy in bullet form
    public static void bullet(category categ) {
        System.out.print(categ.getName() + "\n"); // Print category name
        List<food> elements = categ.getElements(); // Get list of food items in the category
        
        // Loop through food items and print each with a bullet prefix
        for (int i = 0; i < elements.size(); i++) {
            food element = elements.get(i);
            char bulletSymbol='\u2023'; 
            System.out.println(bulletSymbol + element.getName());
        }
    }

    // Prints the hierarchy in ASCII form
    public static void ascii(category categ) {  
        System.out.println(categ.getName()); // Print category name
        
        List<food> elements = categ.getElements(); // Get list of food items in the category
        // Loop through food items and print each with ASCII tree structure
        for (int i = 0; i < elements.size(); i++) {
            food element = elements.get(i);
            System.out.println("      \t  └── " + element.getName());
        }
    }

    // Prints the hierarchy based on the specified format (ASCII or bullet)
    public static void printHierarchy(String format) {
        // Instantiate categories and add food items to them
        category fruits = new category("\t Fruits");
        category meat = new category("\t Meat");
        category dairyProduct = new category("\t Dairy Product");
        category beverage = new category("Beverage");
        category condiments = new category("\t Condiments");
        category vegetable = new category("\t Vegetable");
        category fish = new category("\t Fish");
        category poultry = new category("\t Poultry");
        
        // Instantiating and adding food items to the 'fruits' category
        fruits.addElement(new food("Apple"));
        
        fruits.addElement(new food("Banana"));
        fruits.addElement(new food("Tomato"));
        fruits.addElement(new food("Grapes"));
        fruits.addElement(new food("Pineapple"));

        // Instantiating and adding food items to the 'meat' category
        meat.addElement(new food("Beef"));
        meat.addElement(new food("Chicken"));
        meat.addElement(new food("Pork"));
       
        // Instantiating and adding food items to the 'Dairy Product' category
        dairyProduct.addElement(new food("Butter"));
        dairyProduct.addElement(new food("Cheese"));
        dairyProduct.addElement(new food("Yogurt Cream"));
        dairyProduct.addElement(new food("Milk"));

        // Instantiating and adding food items to the 'Beverage' category
        beverage.addElement(new food("Orange Juice"));
        beverage.addElement(new food("Shake"));

       

        // Instantiating and adding food items to the 'Condiments' category
        condiments.addElement(new food("Soy Sauce"));
        condiments.addElement(new food("Shrimp Paste"));
        condiments.addElement(new food("Fish Sauce"));

        // Instantiating and adding food items to the 'Vegetable' category
        vegetable.addElement(new food("Green Bean"));
        vegetable.addElement(new food("Spinach"));
        vegetable.addElement(new food("Lettuce"));
        vegetable.addElement(new food("Carrots"));
        
        fish.addElement(new food("Shrimp"));
        
        poultry.addElement(new food("Egg"));
        poultry.addElement(new food("Chicken"));
        if ("ascii".equalsIgnoreCase(format)) {
        	
        	System.out.println("  └── " + "Food");
        	
            ascii(fruits);
            ascii(meat);
            ascii(dairyProduct);
         
            
            ascii(condiments);
            ascii(vegetable);
            ascii(fish);
            ascii(poultry);
            System.out.print(" └── ");
            ascii(beverage);
        } else if ("bullet".equalsIgnoreCase(format)) {
        	System.out.println("Food");
            bullet(fruits);
            bullet(meat);
            bullet(dairyProduct);
            bullet(condiments);
            bullet(vegetable);
            bullet(fish);
            bullet(poultry);
            
            
            bullet(beverage);
        } else {
            System.out.println("Invalid format.");
        }     
    }
    
    // Main method to take user input for choice and print hierarchy
    public static void main(String[] args) {
        Scanner ch = new Scanner(System.in);
        System.out.println("How would you like to display the hierarchy?");
        System.out.println("1. ASCII");
        System.out.println("2. Bullet Form");
        System.out.print("Enter your choice: ");
        int choice = ch.nextInt();
        
        // Based on user choice, call printHierarchy with appropriate format
        if (choice == 1) {
        	System.out.println("Consumables");
            printHierarchy("ascii");
        } else if (choice == 2) {
        	System.out.println("Consumables");
            printHierarchy("bullet");
        } else {
        	
            System.out.println("Invalid choice."); // Print message for invalid choice
        }
    }
}
