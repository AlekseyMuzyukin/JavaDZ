package VendingMachines;

import ToyFactory.ToyList;
import Toys.Toy;

import java.io.IOException;
import java.util.*;

public class ToyWendingMachine<T extends Toy> {
    private ArrayList<T> productList;
    private LinkedList<T> winningList;
    private String name;
    private String fileName;
    private Random rand = new Random();


    public ToyWendingMachine(String firstMachine, String fileName) {
        this.name = firstMachine;
        this.fileName = fileName;
        this.productList = new ArrayList<T>();
        this.winningList = new LinkedList<>() {
        };
    }

    public void drawRandomToy() throws IOException {
        if(productList.size() > 0){
            int num = rand.nextInt(productList.size());
            T randToy = productList.get(num);
            System.out.println("You won: {0}" + randToy.toString());
            winningList.add(randToy);
            productList.remove(num);
            System.out.println("Toys left: " + productList.size());
        }
    }

    public void takeToy() throws IOException {
        ToyList fw = new ToyList(this.fileName);
        if(winningList.size() > 0){
            System.out.println(winningList.peek());
            fw.writeToFile(winningList.poll().toString());
        }
        else {
            System.out.println("Winning list is empty");
        }
    }


    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder("Toy Wending Machine:" +
                " name = '" + name +
                "'. Product List = ");
        for (Toy el: productList) {
            sB.append(el.toString() + "\n");
        }

        return sB.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<T> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<T> productList) {
        this.productList = productList;
    }

    public void addProduct(T product) {
        productList.add(product);
    }

    public T getProduct(String name) {
        for (T el : productList) {
            if (el.getName().equals(name)) return el;
        }
        return null;
    }

    public void printProducts() {
        for (T el : this.productList
        ) {
            System.out.println(el);
        }
    }
}