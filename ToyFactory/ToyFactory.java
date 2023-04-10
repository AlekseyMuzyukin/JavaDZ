package ToyFactory;

import Toys.*;

import java.util.ArrayList;
import java.util.Random;

public class ToyFactory {
    protected final Random rand = new Random();
    private final int constructorID = 0;
    private final int modelCarID = 1;
    private final int RabbitID = 2;
    private final int robotID = 3;
    private final int teddyBearID = 4;
    private final int constructorWeight = 10;
    private final int modelCarWeight = 15;
    private final int RabbitWeight = 20;
    private final int robotWeight = 25;
    private final int teddyBearWeight = 30;


    public ArrayList<Toy> generateToyList(int number){
        ArrayList<Toy> res = new ArrayList<>();
        res.add(new Constructors(constructorID, number, constructorWeight));
        res.add(new ModelCars(modelCarID, number, modelCarWeight));
        res.add(new Rabbit(RabbitID, number, RabbitWeight));
        res.add(new Robots(robotID, number, robotWeight));
        res.add(new TeddyBears(teddyBearID, number, teddyBearWeight));
        return res;
    }

    public ArrayList<Toy> generateRandomToyList(int size){
        ArrayList<Toy> res = new ArrayList<>();
        int bound = constructorWeight + modelCarWeight + RabbitWeight + robotWeight + teddyBearWeight;
        for (int i = 0; i < size; i++) {
            int event = rand.nextInt(bound + 1);
            if(event <= constructorWeight){
                res.add(new Constructors(constructorID, 1, constructorWeight));
            } else if (constructorWeight < event && event <= (constructorWeight + modelCarWeight)) {
                res.add(new ModelCars(modelCarID, 1, modelCarWeight));
            } else if ((constructorWeight + modelCarWeight) < event &&
                    event <= (constructorWeight + modelCarWeight + RabbitWeight)) {
                res.add(new Rabbit(RabbitID, 1, RabbitWeight));
            } else if ((constructorWeight + modelCarWeight + RabbitWeight) < event &&
                    event <= (constructorWeight + modelCarWeight + RabbitWeight + robotWeight)) {
                res.add(new Robots(robotID, 1, robotWeight));
            } else if ((constructorWeight + modelCarWeight + RabbitWeight + robotWeight) < event) {
                res.add(new TeddyBears(teddyBearID, 1, teddyBearWeight));
            }
        }
        return res;
    }

    public ArrayList<Toy> generateFlatRandomToyList(int number){
        ArrayList<Toy> res = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int productID = rand.nextInt(5);
            switch (productID) {
                case 0 -> res.add(new Constructors(constructorID, 1, constructorWeight));
                case 1 -> res.add(new ModelCars(modelCarID, 1, modelCarWeight));
                case 2 -> res.add(new Rabbit(RabbitID, 1, RabbitWeight));
                case 3 -> res.add(new Robots(robotID, 1, robotWeight));
                case 4 -> res.add(new TeddyBears(teddyBearID, 1, teddyBearWeight));
            }
        }
        return res;
    }


}