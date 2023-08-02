import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Select an option:");
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Fahrenheit to Celsius");
                System.out.println("3. Celsius to Kelvin");
                System.out.println("4. Kelvin to Celsius");
                System.out.println("5. Fahrenheit to Kelvin");
                System.out.println("6. Kelvin to Fahrenheit");
                System.out.println("7. Quit");
                System.out.print("Enter your choice (1-7): ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading the integer

                if (choice == 7) {
                    System.out.println("Goodbye!");
                    break;
                } else if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice. Please select a valid option.");
                    continue;
                }

                System.out.print("Enter the temperature: ");
                double temperature = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character after reading the double

                double convertedTemperature = convertTemperature(choice, temperature);

                System.out.println("Converted temperature: " + convertedTemperature);
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        scanner.close();
    }

    public static double convertTemperature(int choice, double temperature) {
        switch (choice) {
            case 1: // Celsius to Fahrenheit
                return (temperature * 9 / 5) + 32;
            case 2: // Fahrenheit to Celsius
                return (temperature - 32) * 5 / 9;
            case 3: // Celsius to Kelvin
                return temperature + 273.15;
            case 4: // Kelvin to Celsius
                return temperature - 273.15;
            case 5: // Fahrenheit to Kelvin
                return (temperature + 459.67) * 5 / 9;
            case 6: // Kelvin to Fahrenheit
                return (temperature * 9 / 5) - 459.67;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }
}
