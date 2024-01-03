/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinalsrenz;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class JavaFINALSRENZ {
 private static final String[] item = {"PABO", "Gansa", "PATO", "MANOK", "PUGO"};
    private static final double[] price = {10.0, 20.0, 30.0, 40.0, 50.0};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int choice;
        int quantity;
        double total = 0.0;
        ArrayList<String> receipt = new ArrayList<>(); 

        do {
            choice = showMenu();

            if (choice >= 1 && choice <= item.length) {
                quantity = getQuantity();
                double itemTotal = calculateTotal(choice - 1, quantity);
                total += itemTotal;

                
                receipt.add(item[choice - 1] + " x" + quantity + " - P" + price[choice - 1] + " each - Total: P" + itemTotal);

                int chsy = JOptionPane.showConfirmDialog(null, "Do you want to continue shopping?", "Continue Shopping", JOptionPane.YES_NO_OPTION);
                if (chsy == JOptionPane.NO_OPTION) {
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);

        double discount = total * 0.5;
        double cash = total - discount;
        int discountChoice = JOptionPane.showConfirmDialog(null, "Sexy ka o dili?", "Question", JOptionPane.YES_NO_OPTION);

        if (discountChoice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Total: P" + cash + "\nDiscount Applied: 5%");
        } else {
            JOptionPane.showMessageDialog(null, "Total: P" + total + "\nNo Discount Applied");
        }

        while (true) {
            String input = JOptionPane.showInputDialog(null, "Your total is P" + total + "\nEnter Cash: ");
            int enteredCash = Integer.parseInt(input);
            double change = enteredCash - cash;

            if (enteredCash > cash) {
                JOptionPane.showMessageDialog(null, "Your change is: P" + change);
                displayReceipt(receipt);
                JOptionPane.showMessageDialog(null, "Salamat sa pag palit boss");
                break;
            } else if (enteredCash == cash) {
                JOptionPane.showMessageDialog(null, "Thank you for your payment");
                displayReceipt(receipt);
                JOptionPane.showMessageDialog(null, "Salamat sa pag palit boss");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "INVALID! Please Enter Cash Again.");
            }
        }
    }

    private static int showMenu() {
        StringBuilder menuMessage = new StringBuilder();
        menuMessage.append("Choose a product:\n");

        for (int i = 0; i < item.length; i++) {
            menuMessage.append(i + 1).append(". ").append(item[i]).append(" - P").append(price[i]).append("\n");
        }

        String choiceString = JOptionPane.showInputDialog(null, menuMessage.toString(), "7/7", JOptionPane.QUESTION_MESSAGE);

        try {
            return Integer.parseInt(choiceString);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int getQuantity() {
        String quantityString = JOptionPane.showInputDialog(null, "Enter the quantity:", "Quantity", JOptionPane.QUESTION_MESSAGE);

        try {
            return Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static double calculateTotal(int choice, int quantity) {
        return price[choice] * quantity;
    }

    private static void displayReceipt(ArrayList<String> receipt) {
        StringBuilder receiptMessage = new StringBuilder("Receipt:\n");
        for (String item : receipt) {
            receiptMessage.append(item).append("\n");
        }  
        System.out.println(receiptMessage.toString());
       // System.out.println("cash on hand"+ enteredCash);
       // JOptionPane.showMessageDialog(null, receiptMessage.toString(), "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }
}
    
    

