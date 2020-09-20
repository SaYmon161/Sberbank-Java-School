package part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    public static void sortByType(List<Car> cars) {
        Map<String, List<Car>> carsSortedByTypes = new HashMap<>();

        for (Car car : cars) {
            if (carsSortedByTypes.containsKey(car.type)) {
                List<Car> existedCarsList = carsSortedByTypes.get(car.type);
                existedCarsList.add(car);
                carsSortedByTypes.put(car.type, existedCarsList);
            } else {
                List<Car> newCarsList = new ArrayList<>();
                newCarsList.add(car);
                carsSortedByTypes.put(car.type, newCarsList);
            }
        }

        for (String key : carsSortedByTypes.keySet()) {
            System.out.println(key + ":");
            for (Car car : carsSortedByTypes.get(key)) {
                System.out.println(car.model + " " + car.type);
            }
            System.out.println("================================");
        }
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Lada", "Sedan"));
        cars.add(new Car("BMW", "Sedan"));
        cars.add(new Car("Toyota", "Sedan"));
        cars.add(new Car("Nissan", "Sedan"));
        cars.add(new Car("Lada", "Crossover"));
        cars.add(new Car("BMW", "Crossover"));
        cars.add(new Car("Toyota", "Crossover"));
        cars.add(new Car("Nissan", "Crossover"));
        cars.add(new Car("Lada", "Hatchback"));
        cars.add(new Car("BMW", "Hatchback"));
        cars.add(new Car("Toyota", "Hatchback"));
        cars.add(new Car("Nissan", "Hatchback"));

        sortByType(cars);
    }
}

class Car {
    String model;
    String type;

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }
}