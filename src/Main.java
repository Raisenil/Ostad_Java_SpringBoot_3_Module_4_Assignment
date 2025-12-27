import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get validated input for length and width
        double length = getValidatedDimension(scanner, "length");
        double width = getValidatedDimension(scanner, "width");

        // Perform calculations
        double area = calculate("area", length, width);
        double perimeter = calculate("perimeter", length, width);

        // Display results
        displayResults(length, width, area, perimeter);

        scanner.close();
    }

    public static double getValidatedDimension(Scanner scanner, String dimensionName) {
        double dimension = -1;

        while (dimension <= 0) {
            System.out.print("Enter the " + dimensionName + " of the rectangle: ");

            // Check if input is a valid number
            if (scanner.hasNextDouble()) {
                dimension = scanner.nextDouble();

                // Check if positive
                if (dimension <= 0) {
                    System.out.println("Error: " + dimensionName + " must be a positive number. Please try again.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        return dimension;
    }

    public static double calculate(String calculationType, double length, double width) {
        switch (calculationType.toLowerCase()) {
            case "area":
                return length * width;
            case "perimeter":
                return 2 * (length + width);
            default:
                throw new IllegalArgumentException("Invalid calculation type. Use 'area' or 'perimeter'.");
        }
    }

    public static void displayResults(double length, double width, double area, double perimeter) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("RECTANGLE CALCULATION RESULTS");
        System.out.println("=".repeat(40));
        System.out.printf("Length:     %10.2f units%n", length);
        System.out.printf("Width:      %10.2f units%n", width);
        System.out.printf("Area:       %10.2f square units%n", area);
        System.out.printf("Perimeter:  %10.2f units%n", perimeter);
        System.out.println("=".repeat(40));
    }
}