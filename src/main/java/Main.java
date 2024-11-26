import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static class Car {
        private String name;
        private double speed;


        public Car(String name, double speed) {
            this.name = name;
            this.speed = speed;
        }


        public String getName() {
            return name;
        }





        public double calculateDistance() {
            return speed * 24; // км
        }
    }


    static class Race {
        private List<Car> cars;


        public Race() {
            cars = new ArrayList<>();
        }


        public void addCar(Car car) {
            cars.add(car);
        }


        public Car determineLeader() {
            Car leader = null;
            double maxDistance = 0;

            for (Car car : cars) {
                double distance = car.calculateDistance();
                if (distance > maxDistance) {
                    maxDistance = distance;
                    leader = car;
                }
            }

            return leader;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 0; i < 3; i++) {
            String name;
            double speed;

            System.out.println("Введите название автомобиля:");
            name = scanner.nextLine();

            while (true) {
                System.out.println("Введите скорость автомобиля (0 < скорость ≤ 250):");
                speed = scanner.nextDouble();
                scanner.nextLine();

                if (speed > 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Некорректная скорость! Попробуйте снова.");
                }
            }

            Car car = new Car(name, speed);
            race.addCar(car);
        }

        Car leader = race.determineLeader();

        if (leader != null) {
            System.out.println("Самая быстрая машина: " + leader.getName());
        } else {
            System.out.println("Не удалось определить лидера гонки.");
        }

        scanner.close();
    }
}