package prods;

public class Products {

    int price(int pr) {
        int arr[] = { 47, 55, 50, 20, 6 };
        return arr[pr - 1];
    }

    public int products(int p, int q, int t) {
        for (int i = 1; i <= q; i++)
            t = t + price(p);
        return t;
    }
}
