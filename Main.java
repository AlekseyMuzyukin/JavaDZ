import ToyFactory.ToyFactory;
import VendingMachines.ToyWendingMachine;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ToyWendingMachine toyWendingMachine = new ToyWendingMachine<>("first vending machine", "1.txt");
        System.out.println(toyWendingMachine);
        toyWendingMachine.setProductList(new ToyFactory().generateRandomToyList(100));
        System.out.println(toyWendingMachine);
        System.out.println(toyWendingMachine.getProductList().size());
        for (int i = 0; i < 100; i++) {
            toyWendingMachine.drawRandomToy();
        }
        for (int i = 0; i < 100; i++) {
            toyWendingMachine.takeToy();
        }
    }
}