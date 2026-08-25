import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Race race = new Race();

        System.out.println("Добро пожаловать на гонку '24 часа Ле-Мана'!");

        Car[] cars = new Car[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("--- Автомобиль №" + (i + 1) + " ---");

            System.out.print("Введите название машины: ");
            String name = scanner.nextLine();

            System.out.print("Введите скорость машины: ");
            int speed = scanner.nextInt();

            scanner.nextLine();

            cars[i] = new Car(name, speed);

            race.updateLeader(cars[i]);
        }

        scanner.close();

        System.out.println("=== РЕЗУЛЬТАТЫ ГОНКИ ===");
        System.out.println("Самая быстрая машина: " + race.getWinner());
    }

    static class Car {
        String name;
        int speed;

        public Car(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }
    }

    static class Race {
        private static final int HOURS = 24;

        private String leaderName = "";
        private double maxDistance = 0;

        public void updateLeader(Car car) {
            double currentDistance = HOURS * car.speed;

            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                leaderName = car.name;
            }
        }

        public String getWinner() {
            return leaderName;
        }
    }
}