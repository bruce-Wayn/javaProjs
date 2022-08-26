import java.util.Scanner;

import methods.Menu;
import prods.Products;

class GroceryStoreApplication {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Menu m = new Menu();
        Products p = new Products();
        int pro, qty, total = 0, pay, bal;
        char ch;
        do {
            m.menu();
            System.out.print("Select Product:");
            pro = scan.nextInt();
            System.out.print("Enter Quantity:");
            qty = scan.nextInt();
            total = p.products(pro, qty, total);

            System.out.print("Do you want to shop more?[y/n]:");
            ch = scan.next().charAt(0);
        } while (ch == 'y');

        System.out.println("Total Bill: Rs." + total);
        System.out.print("Kindly Make your payment: ");
        pay = scan.nextInt();
        bal = pay - total;

        if (bal < 0) {
            System.out.println("Kindly pay Rs. " + (bal * (-1)) + " more in order to fulfill your purchase!");
            System.out.println("\nAnd, Thank you for shopping with us");
        } else if (bal >= 0) {
            System.out.println("Kindly collect your balance of Rs. " + bal + " , Thank you for your purchase!");
            System.out.println("\n\n\nThank you for shopping with us");
        }

    }
}
