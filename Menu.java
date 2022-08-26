package methods;

import prods.names;

public class Menu {
    public void menu() {
        System.out.println("----------GROCERY STORE-----------");
        System.out.println("----------------------------------");
        System.out.println("Sl.No.\tItem\tPrice");
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        names p = new names();
        int arr[] = { 47, 55, 50, 20, 6 };
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "\t" + p.prodss(i) + "\t" + arr[i]);
        }

    }
}
